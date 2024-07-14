package com.tests.lesson9_PageObject.tests;

import com.tests.lesson9_PageObject.pages.TextBoxFormPage;
import com.tests.lesson9_PageObject.utils.TestBaseDemoQA;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests extends TestBaseDemoQA {

    TextBoxFormPage.FormData formData = new TextBoxFormPage.FormData(
            "Yaroslav Radzievskiy",
            "Auto@test.qa",
            "Moscow, Mira st. 4",
            "Yugorsk, Mira st. 4");

    @Test
    @DisplayName("Проверка заполнения формы")
    void textBoxFormTest() {
        openPage("/text-box");
        TextBoxFormPage.fillTestBoxForm(formData);
        TextBoxFormPage.submitForm();

        $("#output").shouldHave(
                text(formData.getFullName()),
                text(formData.getEmail()),
                text(formData.getCurrentAddress()),
                text(formData.getPermanentAddress())
        );
    }
}

