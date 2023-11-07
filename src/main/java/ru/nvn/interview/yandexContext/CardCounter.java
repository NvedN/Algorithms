package ru.nvn.interview.yandexContext;

import java.util.Arrays;
import java.util.Scanner;

public class CardCounter {

  public static int maxScore(int[] cards, int k) {
    int n = cards.length;
    int[][] dp = new int[k + 1][n];

    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println("----------------------------------------");
        int left = j;
        int right = n - 1 - (k - i);

        System.out.println("----------left = " + left);
        System.out.println("----------right = " + right);

        // Выбираем максимум из варианта взять карту слева и справа
        int takeLeft = (left < n - 1) ? dp[i - 1][left + 1] : 0;
        int takeRight = (right > 0) ? dp[i - 1][left] : 0;

        System.out.println("----------takeLeft = " + takeLeft);
        System.out.println("----------takeRight = " + takeRight);

        dp[i][j] = Math.max(cards[left] + takeLeft, cards[right] + takeRight);
        System.out.println("----------dp = " + dp[i][j]);
        System.out.println("----------------------------------------");

      }
    }

    System.out.println("----------dp = " + Arrays.deepToString(dp));

    return dp[k][0];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] cards = new int[n];
    for (int i = 0; i < n; i++) {
      cards[i] = scanner.nextInt();
    }
    long maxScore = maxScore(cards, k);
    System.out.println(maxScore);
  }
}
