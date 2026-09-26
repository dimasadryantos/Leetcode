package com.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    /**
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            if (memos.containsKey(current)) {
                return new int[]{memos.get(current), i};
            }
            int calculate = target - current;
            memos.put(calculate, i);
        }
        return new int[]{};
    }

}
