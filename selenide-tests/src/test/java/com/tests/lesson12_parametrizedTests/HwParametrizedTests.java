package com.tests.lesson12_parametrizedTests;

import com.codeborne.selenide.Selenide;
import com.tests.data.BaseTest;
import com.tests.data.HabrLocale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byTagAndText;
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
}
