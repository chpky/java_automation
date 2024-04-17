import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.TestConfig.SetConfig;


public class GithubWebTests {

    @BeforeAll
    static void SetUp() {
        SetConfig("https://github.com");
    }

    @Test
    void Validation() {
        open("/");
        // поле поиска
        $("[placeholder='Search or jump to...']").click();
        // вставить текст в поле поиска
        $("#query-builder-test").setValue("Selenide").pressEnter();
        // найти результат поиска по атрибуту
        $(new ByAttribute("href","/selenide/selenide")).click();
        // убедиться что зашел в нужный репозиторий
        $("#repository-container-header a").shouldHave(text("selenide"));
    }

    @Test
    void IsSolntsevFirstContributor() {
        open("/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest("h2").sibling(0)
                    .$$("li").first()
        .hover();
        $(".Popover").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    @Description("Homework 4")
    void HoverTest() {
        open("/");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a","Enterprise")).click();
        $(byTagAndText("span","Start a free trial")).shouldBe(visible);
    }
}