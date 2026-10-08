package com.example;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {


    public static void main(String[] args) {
        String s = "loveleetcode";
        int index = firstUniqueChar(s);
        System.out.println("The index of the first unique character is: " + index);
    }


    private static int firstUniqueChar(String input) {

        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            seen.put(currentChar, seen.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (seen.get(currentChar) == 1) {
                return i;
            }
        }
        return -1;
    }
}
