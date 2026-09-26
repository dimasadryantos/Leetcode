package com.example;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {


    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }


    public boolean isAnagram(String s, String t) {


//validate only alphabet
//anagram nagaram


//[a,n,a,g,r,a,m] - [n-a-g-a-r-a-m]

//n - 0
//a - 1
//g - 2
//a - 3
//r - 4
//a - 5
//m - 6


        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Integer> seen = new HashMap<>();

        for(int i =0 ; i < t.length() ; i++){
            char char1 = t.charAt(i);
            if(char1 >= 'a' && char1 <= 'z' || char1 >= 'A' && char1 <= 'Z'){
                if(seen.containsKey(char1)){
                    seen.put(char1, seen.get(char1)+1);
                }else{
                    seen.put(char1,1);
                }
            }
        }


        for(int i =0 ; i < s.length() ; i++){
            char char1 = s.charAt(i);

            if(char1 >= 'a' && char1 <= 'z' || char1 >= 'A' && char1 <= 'Z'){

                if(!seen.containsKey(char1)){
                    return false;
                }

                if(seen.get(char1) == 1){
                    seen.remove(char1);
                }else{
                    seen.put(char1,seen.get(char1) -1);
                }
            }
        }

        return seen.isEmpty();
    }
}
