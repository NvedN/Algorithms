package ru.nvn.interview.yandexCodeRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_4 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input = reader.readLine().split(" ");

    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    // Вызов функции для поиска максимального количества цветочков и маршрута
    System.out.println(horseMaxPath(n, m));
  }

  private static int horseMaxPath(int n, int m) {
    int[][] dp = new int[n + 1][m + 1];
    dp[1][1] = 1;
    // Заполнение остальных ячеек
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= m; j++) {
        dp[i][j] = dp[i - 1][j - 2] + dp[i - 2][j - 1];
      }
    }
    return dp[n][m];
  }
}
