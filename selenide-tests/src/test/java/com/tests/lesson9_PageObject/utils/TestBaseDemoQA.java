package com.tests.lesson9_PageObject.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBaseDemoQA {

    public static void SetConfig(String baseUrl, boolean isBrowserStayOpened) {
        Configuration.baseUrl = baseUrl;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = isBrowserStayOpened;
    }

    public void openPage(String pageRoute) {
        open(pageRoute);
    }

    @BeforeAll
    static void SetUp() {
        SetConfig("https://demoqa.com", false);
    }
}
