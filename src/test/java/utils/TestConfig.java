package utils;

import com.codeborne.selenide.Configuration;

public class TestConfig {

    public static void SetConfig(String baseUrl) {
        Configuration.baseUrl = baseUrl;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }
}
