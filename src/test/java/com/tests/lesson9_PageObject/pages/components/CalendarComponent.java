package com.tests.lesson9_PageObject.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-dropdown-container").$(byText(month)).click();
        $(".react-datepicker__year-dropdown-container").$(byText(year)).click();
        $(".react-datepicker__month-container").$(byText(day)).click();
    }
}
