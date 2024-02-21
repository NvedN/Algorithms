package ru.nvn.interview.yandexCodeRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Task_6 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Чтение первой последовательности
    int n = Integer.parseInt(reader.readLine());
    int[] sequence1 = new int[n];
    StringTokenizer tokenizer1 = new StringTokenizer(reader.readLine());
    for (int i = 0; i < n; i++) {
      sequence1[i] = Integer.parseInt(tokenizer1.nextToken());
    }

    // Чтение второй последовательности
    int m = Integer.parseInt(reader.readLine());
    int[] sequence2 = new int[m];
    StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());
    for (int i = 0; i < m; i++) {
      sequence2[i] = Integer.parseInt(tokenizer2.nextToken());
    }

    // Вызов функции для поиска максимального количества цветочков и маршрута
    longestSubSequence(n, sequence1, m, sequence2);
  }

  private static void longestSubSequence(int n, int[] sequence1, int m, int[] sequence2) {

    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (sequence1[i - 1] == sequence2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // Восстановление ответа
    int index = dp[n][m];
    int[] lcs = new int[index];
    int i = n, j = m;
    while (i > 0 && j > 0) {
      if (sequence1[i - 1] == sequence2[j - 1]) {
        lcs[--index] = sequence1[i - 1];
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    // Вывод наибольшей общей подпоследовательности
    for (int k = 0; k < dp[n][m]; k++) {
      System.out.print(lcs[k] + " ");
    }
  }
}
