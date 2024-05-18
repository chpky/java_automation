package com.demoQA.practiceForm.utils;

import com.codeborne.selenide.Configuration;

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

    public static void SetUp() {
        SetConfig("https://demoqa.com", false);
    }
}
