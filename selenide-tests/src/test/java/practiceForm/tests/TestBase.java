package practiceForm.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static utils.TestConfig.SetConfig;

public class TestBase {
    @BeforeAll
    static void SetUp() {
        SetConfig("https://demoqa.com");
    }

    @BeforeEach
    void setUpForm() {
        open("/automation-practice-form");
    }
}
