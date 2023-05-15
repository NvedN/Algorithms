package ru.nvn.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int maxProfit = 0;
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int buyPrice = prices[i];
            i++;
            while (i < n && prices[i] > prices[i - 1]) {
                i++;
            }
            int sellPrice = prices[i - 1];
            maxProfit += sellPrice - buyPrice;
        }
        System.out.println(maxProfit);
    }

}
