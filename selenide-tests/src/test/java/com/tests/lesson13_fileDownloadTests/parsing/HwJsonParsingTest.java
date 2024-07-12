package com.tests.lesson13_fileDownloadTests.parsing;

import com.tests.lesson13_fileDownloadTests.MenuOption;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HwJsonParsingTest {

    ClassLoader cl = HwJsonParsingTest.class.getClassLoader();

    @Test
    void jsonParsingTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (
                InputStream is = cl.getResourceAsStream("testData/example.json");
                InputStreamReader isr = new InputStreamReader(is)
                ) {
            MenuOption json = mapper.readValue(isr, MenuOption.class);
            assertNotNull(json);
            assertEquals("file", json.id);
            assertEquals("File", json.value);

            List<MenuOption.MenuItems> menuItems = json.popup.menuItems;
            assertEquals(3, menuItems.size());
            assertArrayEquals(
                    new String[] {"New", "CreateNewDoc()"},
                    new String[] {menuItems.get(0).value, menuItems.get(0).onClick}
            );

        }
    }
}
