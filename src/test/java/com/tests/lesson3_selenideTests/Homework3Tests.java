package com.tests.lesson3_selenideTests;

import com.tests.data.BaseTest;
import com.tests.lesson9_PageObject.utils.TestBaseDemoQA;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class Homework3Tests extends BaseTest {

    @Test
    void SoftAssertionsExistTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("[data-filterable-for=wiki-pages-filter] a").findBy(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
