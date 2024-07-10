package com.tests.lesson12_parametrizedTests;

import com.codeborne.selenide.Selenide;
import com.tests.data.BaseTest;
import com.tests.data.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideLocaleWebTest extends BaseTest {

    static Stream<Arguments> dataProvider() {
        return Stream.of(Arguments.of(Locale.En, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")), Arguments.of(Locale.Ru, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")));
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "Для локали {0} на сайте https://selenide.org/ должен отображаться список кнопок {1}")
    @Tags({@Tag("Blocker"), @Tag("Web")})
    void selenideLocaleWebTest(Locale testData, List<String> expectedButtons) {
        Selenide.open("https://selenide.org");
        $$("#languages a").find(text(testData.name())).click();
        $$(".main-menu-pages a").filter(visible).shouldHave(texts(expectedButtons));
    }
}
