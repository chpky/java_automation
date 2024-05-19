package com.demoQA.practiceForm.pages;

import com.demoQA.practiceForm.pages.components.CalendarComponent;
import com.demoQA.practiceForm.pages.components.RegistrationResultModal;
import com.demoQA.practiceForm.utils.TestBaseDemoQA;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage extends TestBaseDemoQA {
    static CalendarComponent calendar = new CalendarComponent();
    static RegistrationResultModal modal = new RegistrationResultModal();

    public static String closeFormBut = "#closeLargeModal";

    public static class FormData {

        private String firstName;
        private String lastName;
        private String email;
        private String number;
        private String day;
        private String month;
        private String year;
        private String subjects;
        private File uploadFile;
        private String address;
        private String state;
        private String city;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getNumber() {
            return number;
        }

        public String getDay() {
            return day;
        }

        public String getMonth() {
            return month;
        }

        public String getYear() {
            return year;
        }

        public String getSubjects() {
            return subjects;
        }

        public File getUploadFile() {
            return uploadFile;
        }

        public String getUploadedFileName() {
            return uploadFile.getName();
        }

        public String getAddress() {
            return address;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }

        public FormData(String firstName,
                        String lastName,
                        String email,
                        String number,
                        String day,
                        String month,
                        String year,
                        String subjects,
                        File uploadFile,
                        String address,
                        String state,
                        String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.number = number;
            this.day = day;
            this.month = month;
            this.year = year;
            this.subjects = subjects;
            this.uploadFile = uploadFile;
            this.address = address;
            this.state = state;
            this.city = city;
        }
    }

    public PracticeFormPage openPage() {
        openPage("/automation-practice-form");
        return this;
    }

    public void fillForm(FormData formData) {
        setValue("#firstName", formData.getFirstName());
        setValue("#lastName", formData.getLastName());
        setValue("#userEmail", formData.getEmail());
        click("[for=gender-radio-1]");
        setValue("#userNumber", formData.getNumber());
        setDateOfBirth(formData.getDay(), formData.getMonth(), formData.getYear());
        setSubjects(formData.getSubjects());
        click("[for=hobbies-checkbox-1]");
        uploadFile(formData.getUploadFile());
        setValue("#currentAddress", formData.getAddress());
        selectFromDropdown("#react-select-3-input", formData.getState());
        selectFromDropdown("#react-select-4-input", formData.getCity());
        click("#submit");
    }

    private static void setValue(String selector, String value) {
        $(selector).setValue(value);
    }

    private static void click(String selector) {
        $(selector).click();
    }

    private static void setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
    }

    private static void setSubjects(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();
    }

    private static void uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);
    }

    private static void selectFromDropdown(String selector, String value) {
        $(selector).setValue(value).pressEnter();
    }

    public PracticeFormPage verifyModalAppears() {
        modal.verifyModalAppears();
        return this;
    }

    public PracticeFormPage verifyResult(String key, String value) {
        modal.verifyResult(key, value);
        return this;
    }

    public void closeForm() {
        $(closeFormBut).click();
    }
}
