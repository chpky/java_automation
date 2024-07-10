package com.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    public static void SetConfig(String baseUrl, boolean isBrowserStayOpened) {
        Configuration.baseUrl = baseUrl;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = isBrowserStayOpened;
    }

    @BeforeAll
    static void SetUp() {
        SetConfig("https://google.com", false);
    }
}
