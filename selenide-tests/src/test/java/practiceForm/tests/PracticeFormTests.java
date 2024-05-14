package practiceForm.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static practiceForm.pages.PracticeFormPage.*;
import static utils.TestConfig.SetConfig;

public class PracticeFormTests {
    String firstname = "Yaroslav";
    String lastname = "Radzievskiy";
    String email = "auto@test.qa";
    String number = "8005553535";
    String subjects = "Computer Science";
    String file = "pictures/1.png";
    String address = "Moscow, Mira st. 4";
    String state = "NCR";
    String city = "Noida";

    //values for asserts
    String fullname = firstname + " " + lastname;
    String dateOfBirth = "13 March,1980";
    String hobby = "Sports";
    String image = "1.png";
    String location = "NCR Noida";

    @BeforeAll
    static void SetUp() {
        SetConfig("https://demoqa.com");
    }

    @BeforeEach
    void setUpForm() {
        open("/automation-practice-form");
    }

    @Test
    void FormValidation() {
        FormData formData = new FormData(
                firstname,
                lastname,
                email,
                number,
                subjects,
                file,
                address,
                state,
                city
        );
        fillForm(formData);
        $(submittedFormSelector).shouldHave(
                text(fullname),
                text(email),
                text(number),
                text(dateOfBirth),
                text(subjects),
                text(hobby),
                text(image),
                text(address),
                text(location)
        );
        sleep(2000);
        $(closeFormBut).click();
    }
}
