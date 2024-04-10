import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void SetUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "968x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Проверка заполнения формы")
    void fillForm() {
        open("/text-box");
        $("#userName").setValue("Yaroslav Radzievskiy");
        $("#userEmail").setValue("Auto@test.qa");
        $("#currentAddress").setValue("Moscow, Mira st. 4");
        $("#permanentAddress").setValue("Yugorsk, Mira st. 4");
        $("#submit").click();

        $("#output").shouldHave(
                text("Yaroslav Radzievskiy"),
                text("Auto@test.qa"),
                text("Moscow, Mira st. 4"),
                text("Yugorsk, Mira st. 4")
        );
    }
}

