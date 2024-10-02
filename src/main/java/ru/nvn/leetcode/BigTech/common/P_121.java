package ru.nvn.leetcode.BigTech.common;

public class P_121 {

    public static void main(String[] args) {

//        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{1, 2}));
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}));
//        System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
//        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));


        // 7,6,4,3,1 = 0
        // 1, 2 = 1
        // 7,1,5,3,6,4 = 5
        // 2,1,2,0,1 = 1
        // 3,2,6,5,0,3 = 4
        // 1,2,4,2,5,7,2,4,9,0 = 8

    }


    public static int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }
}
