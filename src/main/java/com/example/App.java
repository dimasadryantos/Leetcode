package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        majorityElement(new int[]{2,2,1,1,1,2,2});


    }


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


    /**
     * Bruteforce solution
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];

                if (profit > result) {
                    result = profit;
                }

            }
        }

        return result;
    }


    public static int maxProfit2(int[] prices) {
        int leftPointer = 0;
        int result = 0;
        int rightPointer = 0;

        for (rightPointer = rightPointer + 1; rightPointer < prices.length; rightPointer++) {


            if (prices[leftPointer] > prices[rightPointer]) {
                leftPointer++;
            }


            int profit = prices[rightPointer] - prices[leftPointer];


            if (profit > result) {
                result = profit;
            }

        }
        return result;
    }


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


    /**
     *
     *
     * Input: nums = [3,2,3]
     * Output: 3
     *
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> memo = new HashMap<>();
        int occurance=0;
        int majorityNumber=0;
        int value= 0;

        for(int num : nums){
            if(memo.containsKey(num)){
                Integer currentValue = memo.get(num);
                memo.put(num, currentValue + 1);
            }else {
                memo.put(num,value+1);
            }

            if(memo.get(num) > occurance){
                majorityNumber= num;
                occurance = memo.get(num);
            }
        }
        return majorityNumber;
    }
}
