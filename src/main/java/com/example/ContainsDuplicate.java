package com.example;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Input: nums = [1,2,3,1]
     * seen.add() returns false if the element is already present in the set, indicating a duplicate.
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            } else {
                seen.add(num);
            }
        }
        return false;
    }

}
