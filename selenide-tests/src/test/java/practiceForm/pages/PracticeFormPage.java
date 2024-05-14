package practiceForm.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    public static String submittedFormSelector = ".modal-body";
    public static String closeFormBut = "#closeLargeModal";

    public static class FormData {

        private final String firstName;
        private final String lastName;
        private final String email;
        private final String number;
        private final String subjects;
        private final String uploadFile;
        private final String address;
        private final String state;
        private final String city;

        public FormData(String firstName,
                        String lastName,
                        String email,
                        String number,
                        String subjects,
                        String uploadFile,
                        String address,
                        String state,
                        String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.number = number;
            this.subjects = subjects;
            this.uploadFile = uploadFile;
            this.address = address;
            this.state = state;
            this.city = city;
        }
    }
    public static void fillForm(FormData formData) {
        $("#firstName").setValue(formData.firstName);
        $("#lastName").setValue(formData.lastName);
        $("#userEmail").setValue(formData.email);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(formData.number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1980")).click();
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue(formData.subjects).pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath(formData.uploadFile);
        $("#currentAddress").setValue(formData.address);
        $("#react-select-3-input").setValue(formData.state).pressEnter();
        $("#react-select-4-input").setValue(formData.city).pressEnter();
        $("#submit").click();
    }
}
