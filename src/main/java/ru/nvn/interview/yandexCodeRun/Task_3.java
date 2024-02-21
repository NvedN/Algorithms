package ru.nvn.interview.yandexCodeRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task_3 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    int[][] field = new int[n][m];

    // считываем поле из ввода
    for (int i = 0; i < n; i++) {
      String[] row = reader.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        field[i][j] = Integer.parseInt(row[j]); // преобразуем символ в число
      }
    }

    // Вызов функции для поиска максимального количества цветочков и маршрута
    Result result = findMaxPath(field);
    System.out.println(result.sum);
    System.out.println(result.route);
  }

  private static class Result {
    int sum;
    String route;

    Result(int sum, String route) {
      this.sum = sum;
      this.route = route;
    }
  }

  private static Result findMaxPath(int[][] field) {
    int n = field.length;
    int m = field[0].length;
    int[][] dp = new int[n][m];
    char[][] route = new char[n][m];

    dp[0][0] = field[0][0];

    for (int i = 1; i < n; i++) {
      dp[i][0] = dp[i - 1][0] + field[i][0];
      route[i][0] = 'D';
    }

    for (int j = 1; j < m; j++) {
      dp[0][j] = dp[0][j - 1] + field[0][j];
      route[0][j] = 'R';
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (dp[i - 1][j] > dp[i][j - 1]) {
          dp[i][j] = dp[i - 1][j] + field[i][j];
          route[i][j] = 'D';
        } else {
          dp[i][j] = dp[i][j - 1] + field[i][j];
          route[i][j] = 'R';
        }
      }
    }

    // Восстановление маршрута
    StringBuilder path = new StringBuilder();
    int i = n - 1;
    int j = m - 1;
    while (i > 0 || j > 0) {
      path.insert(0, route[i][j] + " ");
      if (route[i][j] == 'D') {
        i--;
      } else {
        j--;
      }
    }

    return new Result(dp[n - 1][m - 1], path.toString().trim());
  }
}
