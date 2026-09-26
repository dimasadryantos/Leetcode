package com.example;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


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
