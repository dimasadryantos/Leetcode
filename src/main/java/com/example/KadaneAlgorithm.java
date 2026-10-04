package com.example;

public class KadaneAlgorithm {


    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(arr));
    }


    /**
     *
     *
     *
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;
            for (int j = i; j < arr.length; j++) {
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
     * <p>
     * Kadane's algo
     * <p>
     * If the previous running sum is negative, start fresh with the current number.
     * Otherwise, add the current number to the running sum.
     * Always update the biggest sum seen so far.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (current < 0) {
                current = nums[i];
            } else {
                current = current + nums[i];
            }

            if (current > maxSum) {
                maxSum = current;
            }
        }

        return maxSum;
    }


    /**
     * Container with most water
     *
     * @param heights
     * @return
     */
    public Integer max_area(int[] heights) {
        //heights = [3, 4, 1, 2, 2, 4, 1, 3, 2]
        int leftPointer = 0;
        int rightPointer = heights.length -1;
        int maxArea = 0;

        while (leftPointer < rightPointer){

            int height = Math.min(heights[leftPointer], heights[rightPointer]);
            int width = rightPointer - leftPointer;
            int area = width * height;

            if(area > maxArea){
                maxArea = area;
            }


            if(heights[rightPointer] < heights[leftPointer]){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }

        return maxArea;
    }
}
