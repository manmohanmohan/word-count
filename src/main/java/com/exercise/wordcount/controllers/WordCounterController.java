package com.exercise.wordcount.controllers;

import com.exercise.wordcount.service.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/word-counter")
public class WordCounterController {

    private final WordCounter wordCounter;

    @Autowired
    public WordCounterController(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @PostMapping("/add-words")
    public void addWords(@RequestBody String[] words) {
        wordCounter.addWords(words);
    }

    @GetMapping("/count")
    public int getCount(@RequestParam String word) {
        return wordCounter.getCount(word);
    }
}