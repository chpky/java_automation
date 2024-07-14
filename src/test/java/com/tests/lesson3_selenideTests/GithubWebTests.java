package com.tests.lesson3_selenideTests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.tests.data.BaseTest.SetConfig;
import static io.qameta.allure.Allure.*;


public class GithubWebTests {

    private final String REPOSITORY = "/selenide/selenide";
    private final String FIRST_CONTRIBUTOR = "Andrei Solntsev";

    @BeforeAll
    static void setUp() {
        SetConfig("https://github.com", false);
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void validation() {

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
    void isSolntsevFirstContributorLambdaTest() {
        step("Открываем репозиторий " + REPOSITORY, () -> open(REPOSITORY));
        step("Наводим курсор на первого контрибьютора репозитория", () -> {
            $("div.Layout-sidebar").$(byText("Contributors"))
                    .closest("h2").sibling(0)
                    .$$("li").first()
                    .hover();
        });
        step("Проверяем, что первый контрибьютор - " + FIRST_CONTRIBUTOR, () -> {
            $(".Popover").shouldHave(text(FIRST_CONTRIBUTOR));
            addAttachment("takeScreenshot","image/png", new FileInputStream(takeScreenshot()),"png");
            attachment("Source",WebDriverRunner.getWebDriver().getPageSource());
        });
    }

    @Test
    @Description("Homework 4")
    void HoverTest() {
        open("/");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a","Enterprise")).click();
        $(byTagAndText("span","Start a free trial")).shouldBe(visible);
    }

    public File takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
    }
}