package ru.nvn.interview.yandexCodeRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task_2 {

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
    System.out.println(findCheapestPath(field));
  }

  private static int findCheapestPath(int[][] field) {

    int n = field.length;
    int m = field[0].length;
    // Создаем массив для хранения минимального количества еды в каждой клетке
    int[][] dp = new int[n][m];
    // Начальное значение в левом верхнем углу
    dp[0][0] = field[0][0];
    // Заполняем только вниз
    for (int i = 1; i < n; i++) {
      dp[i][0] = dp[i - 1][0] + field[i][0];
    }
    //     Заполняем только вправо
    for (int j = 1; j < m; j++) {
      dp[0][j] = dp[0][j - 1] + field[0][j];
    }
    //     Заполняем оставшиеся клетки
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + field[i][j];
      }
    }
    return dp[n - 1][m - 1];
  }
}
