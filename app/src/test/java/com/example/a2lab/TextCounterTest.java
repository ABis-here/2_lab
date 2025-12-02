package com.example.a2lab;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.a2lab.utils.TextCounter;

public class TextCounterTest {

    @Test
    public void testEmptyText() {
        assertEquals(0, TextCounter.getWordsCount(""));
        assertEquals(0, TextCounter.getNumbersCount(""));
        assertEquals(0, TextCounter.getSentencesCount(""));
    }

    @Test
    public void testSimpleWord() {
        // Tik vienas žodis
        assertEquals(1, TextCounter.getWordsCount("Labas"));
        assertEquals(0, TextCounter.getNumbersCount("Labas"));
        assertEquals(0, TextCounter.getSentencesCount("Labas"));
    }

    @Test
    public void testTwoWords() {
        // Du žodžiai
        assertEquals(2, TextCounter.getWordsCount("Labas pasauli"));
        assertEquals(0, TextCounter.getNumbersCount("Labas pasauli"));
        assertEquals(0, TextCounter.getSentencesCount("Labas pasauli"));
    }

    @Test
    public void testSentenceWithDot() {
        // Sakinys su tašku
        assertEquals(2, TextCounter.getWordsCount("Labas pasauli."));
        assertEquals(0, TextCounter.getNumbersCount("Labas pasauli."));
        assertEquals(1, TextCounter.getSentencesCount("Labas pasauli."));
    }

    @Test
    public void testNumbersInText() {
        // Tekstas su skaičiais
        assertEquals(2, TextCounter.getWordsCount("Turiu 2 obuolius"));
        assertTrue(TextCounter.getNumbersCount("Turiu 2 obuolius") > 0);
        assertEquals(0, TextCounter.getSentencesCount("Turiu 2 obuolius"));
    }

    @Test
    public void testPunctuationMarks() {
        String tekstas = "Labas, pasauli.";
        assertTrue(TextCounter.getWordsCount(tekstas) > 0);
    }
}