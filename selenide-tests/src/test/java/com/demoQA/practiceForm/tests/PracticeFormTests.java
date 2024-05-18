package com.demoQA.practiceForm.tests;

import com.demoQA.practiceForm.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.demoQA.practiceForm.utils.TestBaseDemoQA;

import static com.demoQA.practiceForm.pages.PracticeFormPage.*;

public class PracticeFormTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
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

    @BeforeAll
    static void setUp() {
        TestBaseDemoQA.SetUp();
    }

    @Test
    void formValidation() {
        practiceFormPage.openPage().fillForm(formData);
        practiceFormPage.verifyModalAppears()
                .verifyResult("Student Name", formData.getFirstName() + " " + formData.getLastName())
                .verifyResult("Student Email", formData.getEmail())
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", formData.getNumber())
                .verifyResult("Date of Birth", formData.getDay() + " " + formData.getMonth() + "," + formData.getYear())
                .verifyResult("Subjects", formData.getSubjects())
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", formData.getUploadFile())
                .verifyResult("Address", formData.getAddress())
                .verifyResult("State and City", formData.getState() + " " + formData.getCity())
                .closeForm();
    }
}
