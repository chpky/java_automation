package herokuApp.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;
import static utils.TestConfig.SetConfig;

public class HerokuAppTests {

    @BeforeAll
    static void SetUp() {
        SetConfig("https://the-internet.herokuapp.com");
    }

    @Test
    void DragNDropWithActionsTest() {
        open("/drag_and_drop");
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void DragNDropWithSelenideTest() {
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    @Description("remove elements ")
    void RemoveElementsTest() {
        open("/add_remove_elements/");
    }
}
