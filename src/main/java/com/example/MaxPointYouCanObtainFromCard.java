package com.example;

public class MaxPointYouCanObtainFromCard {

    /**
     *
     * cards = [2, 11, 4, 5, 3, 9, 2]
     *
     * 2,11,4 = 17
     *
     * 17 - 4 + 2 = 15
     * 15 - 11 + 9 = 13
     * 13 - 2 + 3 = 14
     *
     * max = 17
     *
     * Get the max and look from left to right and right to left and get the max score
     *
     * @param cards
     * @param k
     * @return
     */
    public Integer maxScore(int[] cards, Integer k) {
        int currentScore = 0;

        //   cards = [2,11,4,5,3,9,2]
        // k = 3

        for (int i = 0; i < k; i++) {
            currentScore += cards[i];
        }

        // 17

        int currentMax = currentScore;

        for (int i = 0; i < k; i++) {
            currentScore -= cards[k - 1 - i];
            currentScore += cards[cards.length - 1 - i];
            currentMax = Math.max(currentScore, currentMax);
        }

        return currentMax;
    }


}
