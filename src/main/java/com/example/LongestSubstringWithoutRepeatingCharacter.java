package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {


    public static void main(String[] args) {

        List<String> vendors = new ArrayList<>();
        vendors.add("vendor1");
        vendors.add("vendor2");
        vendors.add("vendor3");
        vendors.add("vendor2");
        vendors.add("vendor4");
        vendors.add("vendor5");
        System.out.println(getVendors(vendors));

    }

    /**
     * Sliding window without fix length,
     * we will use two pointers to create a window and a set to store the characters in the current window.
     * We will move the right pointer to expand the window and the left pointer to shrink the window when we encounter a duplicate character. The maximum length of the substring without repeating characters will be updated during this process.
     * <p>
     * String s = "abcabcbb";
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxCurrent = 0;
        Set<Character> seen = new HashSet<>();

        //Input: s = "abcabcbb"
        //Output: 3
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currentChar);
            maxCurrent = Math.max(maxCurrent, right - left + 1);
        }
        return maxCurrent;
    }


    /**
     *
     * Practice question: Given a list of vendors, return the longest consecutive section without duplicate vendors, preserving their original order.
     * <p>
     * Input:
     * ["vendor1", "vendor2", "vendor3", "vendor2", "vendor4", "vendor5"]
     * <p>
     * Expected output:
     * ["vendor3", "vendor2", "vendor4", "vendor5"]
     *
     * @return
     */
    public static List<String> getVendors(List<String> vendors) {

        Set<String> seen = new HashSet<>();
        int left = 0;
        int currentMaxLength = 0;
        int maxStartIndex = 0;

        for (int right = 0; right < vendors.size(); right++) {
            String currentVendor = vendors.get(right);

            while (seen.contains(currentVendor)) {
                seen.remove(vendors.get(left));
                left++;
            }

            seen.add(currentVendor);

            int length = right - left + 1;

            if (length > currentMaxLength) {
                currentMaxLength = length;
                maxStartIndex = left;
            }
        }


        List<String> longestSectionList = new ArrayList<>();
        for (int i = maxStartIndex; i < maxStartIndex + currentMaxLength; i++) {
            longestSectionList.add(vendors.get(i));
        }

        return longestSectionList;
    }

}
