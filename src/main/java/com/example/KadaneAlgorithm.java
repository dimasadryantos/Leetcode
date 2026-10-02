package com.example;

public class KadaneAlgorithm {


    public static void main(String[] args) {
        int[] arr = {2, -3, 4};

        System.out.println(getMax(arr));
    }


    public static int getMax(int[] arr) {
        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;
            for (int j = i ; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }


    /**
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     *
     * Kadane's algo
     *
     * Use it to find the largest sum of a contiguous subarray, with at least one element and no fixed length.
     * If the previous running sum is negative, replace it with the current number. Otherwise, add the current number. Always remember the biggest sum.
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int current = nums[0];
        int maxSum = nums[0];

        for(int i = 1 ; i < nums.length ; i++){

            if(current < 0){
                current = nums[i];
            }else {
                current = current + nums[i];
            }

            if(current > maxSum){
                maxSum = current;
            }
        }

        return maxSum;
    }
}
