import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homework_2_Tests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "968x1080";
    }

    @BeforeEach
    void setUpForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Yaroslav");
        $("#lastName").setValue("Radzievskiy");
        $("#userEmail").setValue("auto@test.qa");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1980")).click();
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue("com").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("pictures/1.png");
        $("#currentAddress").setValue("Moscow, Mira st. 4");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();
    }

    @Test
    void FormValidation() {
        $(".modal-body").shouldHave(
                text("Yaroslav Radzievskiy"),
                text("auto@test.qa"),
                text("auto@test.qa"),
                text("8800555353"),
                text("13 March,1980"),
                text("Computer Science"),
                text("Sports"),
                text("1.png"),
                text("Moscow, Mira st. 4"),
                text("NCR Noida")
        );
        $("#closeLargeModal").click();
    }
}
