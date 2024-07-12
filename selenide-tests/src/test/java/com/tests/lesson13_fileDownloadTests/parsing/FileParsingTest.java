package com.tests.lesson13_fileDownloadTests.parsing;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.tests.lesson13_fileDownloadTests.Human;
import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileParsingTest {

    ClassLoader cl = FileParsingTest.class.getClassLoader();

    @Test
    void fileParsingTest() throws Exception {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href='junit-user-guide-5.10.3.pdf']").download();
        PDF pdf = new PDF(download);
        Assertions.assertEquals("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein", pdf.author);
    }

    @Test
    void xlsParsingTest()  {
        Selenide.open("https://rosstat.gov.ru/reporting");
        File download = $("a[href*='.xlsx']").download();
        XLS xls = new XLS(download);
        Assertions.assertEquals("Сведения о деятельности коллективного средства размещения", xls.excel.getSheetAt(0).getRow(3).getCell(3).getStringCellValue());
    }

    @Test
    void csvParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testData/qa.csv");
             InputStreamReader isr = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(isr);
            List<String[]> content = csvReader.readAll();
            assertArrayEquals(new String[] {"Devis", "Science"}, content.get(1));
        }
    }

    @Test
    void zipParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testData/sample.txt.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry zipEntry;
            while ((zipEntry = zs.getNextEntry()) != null) {
                Assertions.assertEquals("sample.txt", zipEntry.getName());
            }
        }
    }

    @Test
    void jsonCleverTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("testData/human.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            Human human = objectMapper.readValue(isr, Human.class);

            Assertions.assertEquals("Dima", human.name);
            Assertions.assertEquals(33, human.age);
        }
    }

    @Test
    void jsonParsingTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("testData/human.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            JsonNode parsedJson = objectMapper.readTree(isr);

            Assertions.assertEquals("Dima", parsedJson.get("name").asText());
            Assertions.assertEquals(33, parsedJson.get("age").asInt());
        }


    }
}
