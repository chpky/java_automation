package ru.qa.school.core.exaplesOfInterwiewTasks;

import static java.lang.Character.isLetter;
import static java.lang.Character.toUpperCase;
import static java.lang.String.valueOf;

public class StringTask {

    public static void main(String[] args) {
        var string = "lorem ipsum dolor sit amet";
        System.out.println(makeFirstLettersCapitalWithChar(string));
        //System.out.println(makeFirstLettersCapitalWithInt(string));
    }

    static String makeFirstLettersCapitalWithChar(String s) {
        var str = new StringBuilder(s);
        var count = 0;
        var sArray = s.trim().toCharArray();
        for (char character : sArray) {
            if (character == ' ' && isLetter(sArray[count + 1])) {
                str.replace(count + 1, count + 2, valueOf(toUpperCase(sArray[count + 1])));
            }
            count++;
        }
        return valueOf(str);
    }
    static String makeFirstLettersCapitalWithInt(String s) {
        var str1 = new StringBuilder(s);
        var sArray = s.trim().toCharArray();
        for (int i : sArray) {
            if (sArray[i] == ' ' && isLetter(sArray[i + 1])) {
                str1.replace(i + 1, i + 2, valueOf(toUpperCase(sArray[i + 1])));
            }
        }
        return valueOf(str1);
    }
}
