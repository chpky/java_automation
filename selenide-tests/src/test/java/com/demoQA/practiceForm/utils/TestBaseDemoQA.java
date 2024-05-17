package com.demoQA.practiceForm.utils;

import com.codeborne.selenide.Configuration;
import com.demoQA.practiceForm.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoQA.practiceForm.pages.PracticeFormPage.closeFormBut;
import static com.demoQA.practiceForm.pages.PracticeFormPage.submittedFormSelector;

public class TestBaseDemoQA {

    public static void SetConfig(String baseUrl, boolean isBrowserStayOpened) {
        Configuration.baseUrl = baseUrl;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = isBrowserStayOpened;
    }

    public static void openPage(String pageRoute) {
        open(pageRoute);
    }

    protected static void closeForm() {
        $(closeFormBut).click();
    }

    @BeforeAll
    static void SetUp() {
        SetConfig("https://demoqa.com", false);
    }


    protected void verifyFormSubmission(PracticeFormPage.FormData formData) {
            $(submittedFormSelector).shouldHave(
                    text(formData.getFirstName() + " " + formData.getLastName()),
                    text(formData.getEmail()),
                    text(formData.getNumber()),
                    text(formData.getDay() + " " + formData.getMonth() + "," + formData.getYear()),
                    text(formData.getSubjects()),
                    text("Sports"),
                    text(formData.getUploadFile()),
                    text(formData.getAddress()),
                    text(formData.getState() + " " + formData.getCity())
            );
        }
}
