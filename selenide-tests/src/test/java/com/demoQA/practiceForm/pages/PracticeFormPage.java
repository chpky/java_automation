package com.demoQA.practiceForm.pages;

import java.util.HashMap;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    public static String submittedFormSelector = ".modal-body";
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
        private String uploadFile;
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
        public String getUploadFile() {
            return uploadFile;
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
                        String uploadFile,
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

    public static void fillForm(FormData formData) {
        setValue("#firstName", formData.getFirstName());
        setValue("#lastName", formData.getLastName());
        setValue("#userEmail", formData.getEmail());
        click("[for=gender-radio-1]");
        setValue("#userNumber", formData.getNumber());
        setDateOfBirth(formData.getDay(), formData.getMonth(), formData.getYear());
        setSubjects(formData.getSubjects());
        click("[for=hobbies-checkbox-1]");
        uploadFile("#uploadPicture", formData.getUploadFile());
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
        $(".react-datepicker__month-dropdown-container").$(byText(month)).click();
        $(".react-datepicker__year-dropdown-container").$(byText(year)).click();
        $(".react-datepicker__month-container").$(byText(day)).click();
    }

    private static void setSubjects(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();
    }

    private static void uploadFile(String selector, String filePath) {
        $(selector).uploadFromClasspath("pictures/"+filePath);
    }

    private static void selectFromDropdown(String selector, String value) {
        $(selector).setValue(value).pressEnter();
    }
}
