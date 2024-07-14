package com.tests.lesson12_parametrizedTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled
@DisplayName("Простые демонстрационные тесты")
public class SimpleTest {

    @Disabled("Jira-ticket")
    @Test
    @DisplayName("Проверка корректности работы метода")
    void simpleTest() {
        String actual = methodEx();
        Assertions.assertEquals("1", actual, "failed");
    }

    String methodEx() {
        return "1";
    }
}
