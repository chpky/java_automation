package com.demoQA.practiceForm.tests;

import com.demoQA.practiceForm.pages.PracticeFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.demoQA.practiceForm.utils.TestBaseDemoQA;


import static com.demoQA.practiceForm.pages.PracticeFormPage.*;
import static com.demoQA.practiceForm.utils.RandomDataGenerator.*;

public class PracticeFormTests extends TestBaseDemoQA {

    String randomState = getRandomState();
    String randomCity = getRandomCity(randomState);
    private PracticeFormPage practiceFormPage;
    private FormData formData;
    @BeforeEach
    public void prepareTestData() {
        practiceFormPage = new PracticeFormPage();
        formData = new FormData(
                getRandomFirstName(),
                getRandomLastName(),
                getRandomEmail(),
                getRandomPhoneNumber(),
                getRandomDay(),
                getRandomMonth(),
                getRandomYear(),
                "Computer Science",
                getRandomPngFile(),
                getRandomAddress(),
                randomState,
                randomCity
        );
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
                .verifyResult("Picture", formData.getUploadedFileName())
                .verifyResult("Address", formData.getAddress())
                .verifyResult("State and City", formData.getState() + " " + formData.getCity())
                .closeForm();
    }

    @AfterEach
    public void cleanupGeneratedFiles() {
        deleteFile();
    }
}
