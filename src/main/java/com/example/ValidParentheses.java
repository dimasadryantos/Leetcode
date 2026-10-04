package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {


    /**
     *
     * Stack last in first out
     * stack.push ( insert )
     * stack.pop ( remove / the last )
     * isEmpty ( check if empty )
     * <p>
     * https://leetcode.com/problems/valid-parentheses/description/
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            if (word == '(' || word == '{' || word == '[') {
                stack.push(word);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if (word == ')' && opening != '(') {
                    return false;
                }

                if (word == ']' && opening != '[') {
                    return false;
                }

                if (word == '}' && opening != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

