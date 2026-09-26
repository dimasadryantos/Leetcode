package com.example;

public class BestTimeToBuyAndSellStock {

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


}
