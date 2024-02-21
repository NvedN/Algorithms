package ru.nvn.interview.yandexContext;

import java.util.Scanner;

public class CardCounter {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] cards = new int[n];

    for (int i = 0; i < n; i++) {
      cards[i] = scanner.nextInt();
    }

    int[][] dp = new int[n][k + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = cards[i];
    }

    for (int j = 1; j <= k; j++) {
      for (int i = 0; i < n; i++) {
        if (i == 0) {
          dp[i][j] = Math.max(dp[i][j - 1] + cards[i], dp[i + 1][j - 1] + cards[i]);
        } else if (i == n - 1) {
          dp[i][j] = Math.max(dp[i][j - 1] + cards[i], dp[i - 1][j - 1] + cards[i]);
        } else {
          dp[i][j] = Math.max(dp[i + 1][j - 1] + cards[i], dp[i - 1][j - 1] + cards[i]);
        }
      }
    }

    System.out.println(dp[0][k]);
  }

}
