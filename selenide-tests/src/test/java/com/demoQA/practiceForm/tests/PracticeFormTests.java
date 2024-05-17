package com.demoQA.practiceForm.tests;

import org.junit.jupiter.api.Test;
import com.demoQA.practiceForm.utils.TestBaseDemoQA;

import static com.demoQA.practiceForm.pages.PracticeFormPage.*;

public class PracticeFormTests extends TestBaseDemoQA {
    FormData formData = new FormData(
            "Yaroslav",
            "Radzievskiy",
            "auto@test.qa",
            "8005553535",
            "13",
            "March",
            "1980",
            "Computer Science",
            "1.png",
            "Moscow, Mira st. 4",
            "NCR",
            "Noida"
    );

    @Test
        void formValidation() {
            openPage("/automation-practice-form");
            fillForm(formData);
            verifyFormSubmission(formData);
            closeForm();
    }
}
