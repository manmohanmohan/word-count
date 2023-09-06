package com.exercise.wordcount;

import com.exercise.wordcount.Exceptions.WordCounterException;
import com.exercise.wordcount.service.Translator;
import com.exercise.wordcount.service.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WordCounterTest {
    private WordCounter wordCounter;
    private Translator translator;

    @BeforeEach
    public void setUp() {
        translator = mock(Translator.class);
        wordCounter = new WordCounter(translator);
    }

    @Test
    public void testAddWordsAndCount() {
        when(translator.translate("flower")).thenReturn("flower");
        when(translator.translate("flor")).thenReturn("flower");
        when(translator.translate("blume")).thenReturn("flower");

        wordCounter.addWords("flower", "flor", "blume");

        assertEquals(3, wordCounter.getCount("flower"));
    }

    @Test
    public void testAddNonAlphaWord() {
        assertThrows(WordCounterException.class, () -> wordCounter.addWords("123"));
    }
}