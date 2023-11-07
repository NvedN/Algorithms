package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.Scanner;

public class L {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(); // количество слитков
    int m = scanner.nextInt(); // вместимость рюкзака
    int[] weights = new int[n]; // массив масс слитков
    for (int i = 0; i < n; i++) {
      weights[i] = scanner.nextInt();
    }
    int[] dp = new int[m + 1]; // массив для динамического программирования
    for (int i = 1; i <= n; i++) {
      for (int j = m; j >= weights[i - 1]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + weights[i - 1]);
      }
    }
    System.out.println(dp[m]); // выводим максимальную массу слитков
  }
}
