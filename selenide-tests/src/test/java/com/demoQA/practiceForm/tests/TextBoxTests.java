package com.demoQA.practiceForm.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoQA.practiceForm.utils.TestBaseDemoQA;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.demoQA.practiceForm.pages.TextBoxFormPage.*;

public class TextBoxTests extends TestBaseDemoQA {

    FormData formData = new FormData(
            "Yaroslav Radzievskiy",
            "Auto@test.qa",
            "Moscow, Mira st. 4",
            "Yugorsk, Mira st. 4");

    @Test
    @DisplayName("Проверка заполнения формы")
    void textBoxFormTest() {
        openPage("/text-box");
        fillTestBoxForm(formData);
        submitForm();

        $("#output").shouldHave(
                text(formData.getFullName()),
                text(formData.getEmail()),
                text(formData.getCurrentAddress()),
                text(formData.getPermanentAddress())
        );
    }

}

