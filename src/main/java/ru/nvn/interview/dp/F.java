package ru.nvn.interview.dp;

import java.util.Scanner;

public class F {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int mod = 1000000007;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        if (i - j >= 1) {
          dp[i] = (dp[i] + dp[i - j]) % mod;
        }
      }
    }
    System.out.println(dp[n]);
  }
}
