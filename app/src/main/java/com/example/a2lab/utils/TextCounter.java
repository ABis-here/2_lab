package com.example.a2lab.utils;

public class TextCounter {

    // REGEX #1:
    public static int getWordsCount(String input) {
        if (input == null) return 0;

        java.util.regex.Matcher m = java.util.regex.Pattern
                .compile("[\\p{L}]+")
                .matcher(input);

        int c = 0;
        while (m.find()) c++;
        return c;
    }

    // REGEX #2:
    public static int getNumbersCount(String input) {
        if (input == null) return 0;
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("\\b\\d+\\b").matcher(input);
        int c = 0;
        while (m.find()) c++;
        return c;
    }

    // BE REGEX #1
    public static int getSentencesCount(String input) {
        if (input == null) return 0;
        int c = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '.') c++;
        }
        return c;
    }

    // BE REGEX #2:
    public static int getPunctuationCount(String input) {
        if (input == null) return 0;
        int c = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ' ' || ch == ',' || ch == '.') c++;
        }
        return c;
    }
}
