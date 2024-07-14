package com.tests.lesson9_PageObject.tests;

import com.tests.lesson9_PageObject.pages.PracticeFormPage;
import com.tests.lesson9_PageObject.utils.RandomDataGenerator;
import com.tests.lesson9_PageObject.utils.TestBaseDemoQA;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBaseDemoQA {

    String randomState = RandomDataGenerator.getRandomState();
    String randomCity = RandomDataGenerator.getRandomCity(randomState);
    private PracticeFormPage practiceFormPage;
    private PracticeFormPage.FormData formData;
    @BeforeEach
    public void prepareTestData() {
        practiceFormPage = new PracticeFormPage();
        formData = new PracticeFormPage.FormData(
                RandomDataGenerator.getRandomFirstName(),
                RandomDataGenerator.getRandomLastName(),
                RandomDataGenerator.getRandomEmail(),
                RandomDataGenerator.getRandomPhoneNumber(),
                RandomDataGenerator.getRandomDay(),
                RandomDataGenerator.getRandomMonth(),
                RandomDataGenerator.getRandomYear(),
                "Computer Science",
                RandomDataGenerator.getRandomPngFile(),
                RandomDataGenerator.getRandomAddress(),
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
        RandomDataGenerator.deleteFile();
    }
}
