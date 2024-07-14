package com.tests.lesson9_PageObject.pages;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxFormPage {

    public static class FormData {

        private String fullName;
        private String email;
        private String currentAddress;
        private String permanentAddress;

        public FormData(String fullName,
                        String email,
                        String currentAddress,
                        String permanentAddress) {
            this.fullName = fullName;
            this.email = email;
            this.currentAddress = currentAddress;
            this.permanentAddress = permanentAddress;
        }

        public String getFullName() {
            return fullName;
        }
        public String getEmail() {
            return email;
        }
        public String getCurrentAddress() {
            return currentAddress;
        }
        public String getPermanentAddress() {
            return permanentAddress;
        }
    }
    public static void fillTestBoxForm(FormData formData) {
        $("#userName").setValue(formData.fullName);
        $("#userEmail").setValue(formData.email);
        $("#currentAddress").setValue(formData.currentAddress);
        $("#permanentAddress").setValue(formData.permanentAddress);
    }

    public static void submitForm() {
        $("#submit").click();
    }
}
