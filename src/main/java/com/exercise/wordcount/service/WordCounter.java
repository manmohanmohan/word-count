package com.exercise.wordcount.service;

import com.exercise.wordcount.Exceptions.WordCounterException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordCounter {
    private final Map<String, Integer> wordCountMap = new HashMap<>();
    private final Translator translator;

    public WordCounter(Translator translator) {
        this.translator = translator;
    }

    public void addWords(String... words) {
        for (String word : words) {
            if (isAlpha(word)) {
                String translatedWord = translator.translate(word);
                wordCountMap.put(translatedWord, wordCountMap.getOrDefault(translatedWord, 0) + 1);
            } else {
                throw new WordCounterException("Non-alphabetic characters are not allowed.");
            }
        }
    }

    public int getCount(String word) {
        String translatedWord = translator.translate(word);
        return wordCountMap.getOrDefault(translatedWord, 0);
    }

    private boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }
}