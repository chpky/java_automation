package com.tests.lesson12_parametrizedTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.tests.data.BaseTest;
import com.tests.data.HabrLocale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HwParametrizedTests extends BaseTest {

    public static Stream<Arguments> habrLocaleTest() {
        return Stream.of(
                Arguments.of(
                        HabrLocale.Русский,
                        List.of("Моя лента", "Все потоки", "Разработка", "Администрирование", "Дизайн", "Менеджмент", "Маркетинг", "Научпоп")
                ),
                Arguments.of(
                        HabrLocale.English,
                        List.of("My feed", "All streams", "Development", "Admin", "Design", "Management", "Marketing", "PopSci")
                )
        );
    }

    @MethodSource
    @Tag("Blocker")
    @Tag("Habr")
    @ParameterizedTest(name = "Для локали {0} шапка сайта должна содержать {1}")
    public void habrLocaleTest(HabrLocale locale, List<String> expectedBtns) {
        Selenide.open("https://habr.com");
        $("button.tm-footer__link").click();
        $(byTagAndText("label",locale.name())).click();
        $("button.tm-page-settings-form__submit").click();
        $$("nav.tm-main-menu__section-content a").shouldHave(texts(expectedBtns));
    }

    @ValueSource(strings = {"Качество", "Автоматизация", "Java"})
    @ParameterizedTest(name = "При поиске {0} происходит редирект на статью о {0}")
    public void wikipediaSearchTest(String searchString) {
        Selenide.open("https://ru.wikipedia.org/");
        $("#searchInput").setValue(searchString);
        $("#searchButton").click();
        $("#firstHeading span").shouldHave(Condition.text(searchString));
    }

    @CsvSource(value = {
            "124,248,50%",
            "0.1,1000,0.01%"
    })
    @ParameterizedTest
    public void percentCalcTest(String firstNum, String secondNum, String result) {
        Selenide.open("https://calculator888.ru/calculator-procentov");
        $("#ch1_2").setValue(firstNum);
        $("#ch2_2").setValue(secondNum);
        $(withText("Сколько % составляет число")).$(byAttribute("value", "ОК")).click();
        $("#itog_2").shouldHave(Condition.text(result));
    }
}
