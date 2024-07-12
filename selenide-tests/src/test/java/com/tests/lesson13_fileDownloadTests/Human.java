package com.tests.lesson13_fileDownloadTests;

import java.util.List;

public class Human {
    public String name;
    public Integer age;
    public Boolean isClever;
    public List<String> hobbies;
    public Passport passport;

    public static class Passport {
        public Integer number;
        public String issueDate;
    }
}
