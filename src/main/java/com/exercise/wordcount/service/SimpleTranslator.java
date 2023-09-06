package com.exercise.wordcount.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SimpleTranslator implements Translator {
    private final Map<String, String> translationMap;

    public SimpleTranslator(Map<String, String> translationMap) {
        this.translationMap = translationMap;
    }

    @Override
    public String translate(String word) {
        return translationMap.getOrDefault(word, word);
    }
}