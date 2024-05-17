package practiceForm.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static practiceForm.pages.PracticeFormPage.*;

public class PracticeFormTests extends TestBase{

    @Test
    void FormValidation() {
        FormData formData = new FormData(
                "Yaroslav",
                "Radzievskiy",
                "auto@test.qa",
                "8005553535",
                "Computer Science",
                "pictures/1.png",
                "Moscow, Mira st. 4",
                "NCR",
                "Noida"
        );
        fillForm(formData);
        $(submittedFormSelector).shouldHave(
                text("Yaroslav Radzievskiy"),
                text("auto@test.qa"),
                text("8005553535"),
                text("13 March,1980"),
                text("Computer Science"),
                text("Sports"),
                text("1.png"),
                text("Moscow, Mira st. 4"),
                text("NCR Noida")
        );
        sleep(2000);
        $(closeFormBut).click();
    }
}
