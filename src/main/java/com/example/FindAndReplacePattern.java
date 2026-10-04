package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {


    //["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    //mee - abb (patern)
    //patternToWord = a - m
    //wordToPattern = m - a

    //patternToWord = b - e
    //wordToPattern = e - b


    //


    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }


    private boolean matches(String word, String pattern) {
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();


        for (int i = 0; i < word.length(); i++) {
            char cWord = word.charAt(i);
            char cPattern = pattern.charAt(i);

            if (patternToWord.containsKey(cPattern)
                && patternToWord.get(cPattern) != cWord) {
                return false;
            }

            if (wordToPattern.containsKey(cWord)
                && wordToPattern.get(cWord) != cPattern) {
                return false;
            }

            patternToWord.put(cPattern, cWord);
            wordToPattern.put(cWord, cPattern);

        }
        return true;
    }
}
