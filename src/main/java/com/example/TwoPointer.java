package com.example;

/**
 *
 * Two pointers = two positions + a rule for moving them safely.
 */
public class TwoPointer {


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 8, 10, 13};
        int target = 13;

        twoSum(nums, target);
    }

    private static void bruteForce2Sum() {
        int[] nums = {1, 3, 4, 6, 8, 10, 13};
        int target = 13;


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    System.out.println("Found the pair: " + nums[i] + " and " + nums[j]);
                }
            }
        }
    }

    /**
     *
     * int[] nums = {1, 3, 4, 6, 8, 10, 13};
     * int target = 13;
     *
     * @param nums
     * @param target
     * @return
     */

    public static boolean twoSum(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer < rightPointer) {

            int sum = nums[leftPointer] + nums[rightPointer];
            if (sum == target) {
                System.out.println("We found it!" + " " + sum);
                return true;
            }

            if (sum > target) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }
        return false;
    }


    public Integer max_area(int[] heights) {
        //heights = [3, 4, 1, 2, 2, 4, 1, 3, 2]
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {

            int height = Math.min(heights[leftPointer], heights[rightPointer]);
            int width = rightPointer - leftPointer;
            int area = width * height;

            if (area > maxArea) {
                maxArea = area;
            }


            if (heights[rightPointer] < heights[leftPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }

        return maxArea;
    }
}
