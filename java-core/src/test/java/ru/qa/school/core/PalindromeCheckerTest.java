package ru.qa.school.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.qa.school.core.petstore.PalindromChecker;

public class PalindromeCheckerTest {

    @Test
    @DisplayName("Проверка функции PalindromChecker")
    public void isPalindromeTest() {
        assertTrue(PalindromChecker.isPalindrom("anna"));
        assertFalse(PalindromChecker.isPalindrom("annag"));
    }
}
