package ru.nvn.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] pricesStr = reader.readLine().split(" ");
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(pricesStr[i]);
        }

        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }

        System.out.println(profit);
    }
}
