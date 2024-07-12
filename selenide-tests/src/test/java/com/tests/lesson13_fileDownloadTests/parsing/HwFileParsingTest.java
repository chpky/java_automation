package com.tests.lesson13_fileDownloadTests.parsing;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class HwFileParsingTest {


    ClassLoader classLoader = HwFileParsingTest.class.getClassLoader();
    @Test
    void zipParsingTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("testData/hw13.zip");
        ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                String name = ze.getName();
                switch (name) { //TODO разделить условия на отдельные тесты
                    case "fileXls.xlsx": {
                        XLS xls = new XLS(zis);
                        assertEquals("isTestingData", xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
                        break;
                    }
                    case "cv.pdf": {
                        PDF pdf = new PDF(zis);
                        assertEquals(19, pdf.numberOfPages);
                        assertTrue(pdf.text.startsWith("Как составить"));
                        break;
                    }
                    case "qa.csv": {
                        InputStreamReader isr = new InputStreamReader(zis);
                        CSVReader csv = new CSVReader(isr);
                        List<String[]> lines = csv.readAll();
                        assertEquals(2, lines.size());
                        assertArrayEquals(new String[]{"teacher", "lesson"}, lines.getFirst());
                        break;
                    }
                }
            }
        }
    }
}
