package com.tests.lesson12_parametrizedTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.tests.data.Blocker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SimpleWebTest {

    @BeforeEach
    void setUp() {
        Selenide.open("https://www.ya.ru");
    }

    @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest(name = "В поисковой выдаче должно отображаться 10 результатов по запросу {0}")
    @Tags({@Tag("Blocker"), @Tag("Web")})
    void searchTest(String testData) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("[data-fast='1']").shouldHave(sizeGreaterThanOrEqual(10));
    }

    @CsvSource(value = {
            "Selenide java | Selenide: лаконичные и стабильные UI тесты на Java",
            "Allure Framework | Allure Report — Open-source HTML test automation report tool"
    },
    delimiter = '|'
    )
    @ParameterizedTest(name = "в результате выдачи для {0} должен отображаться текст {1}")
    @Tags({@Tag("Blocker"), @Tag("Web")})
    void searchWithFirstResultCheckTest(String testData, String expectedText) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").first().shouldHave(Condition.text(expectedText));

    }

    @Test
    @DisplayName("Проверка числа результатов в поиске")
    @Blocker
    void photoSearchTest() {
        $("#image-search").uploadFile(new File("src/test/resources/pictures/1.png"));
        $("div.cbir-intent__title").shouldHave(text("Загруженная картинка"));
    }
}
