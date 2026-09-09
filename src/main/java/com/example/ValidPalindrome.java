package com.example;

public class ValidPalindrome {


    /**
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     *
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     *
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     *
     *
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {


        // Palindrome if :
        // - all uppercase letters into lower case
        // - removing all non-alpahanumeric characteres,
        // - it reads the same forwards and backwards

        String baseLowerCase = s.toLowerCase();
        int front = 0;
        int back = s.length() -1;


        //aba
        //race a car

        while(front < back){
            char frontLetter = baseLowerCase.charAt(front);
            char backLetter = baseLowerCase.charAt(back);


            if(!isAlphaNumeric(frontLetter)){
                front++;
                continue;
            }

            if(!isAlphaNumeric(backLetter)){
                back--;
                continue;
            }


            if(frontLetter != backLetter){
                return false;
            }

            front++;
            back--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        boolean isLetter =  c >= 'a' && c <= 'z';
        boolean isNumber = c >= '0' && c <= '9';
        return isLetter || isNumber;
    }
}
