package com.github;

import com.demoQA.practiceForm.utils.TestBaseDemoQA;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Homework3Tests extends TestBaseDemoQA {

    @Test
    void SoftAssertionsExistTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("[data-filterable-for=wiki-pages-filter] a").findBy(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
