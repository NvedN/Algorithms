package ru.nvn.interview.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    int[][] field = new int[n][m];

    // считываем поле из ввода
    for (int i = 0; i < n; i++) {
      String row = reader.readLine();
      for (int j = 0; j < m; j++) {
        field[i][j] = row.charAt(j) - '0'; // преобразуем символ в число
      }
    }

      // Вызов функции для поиска максимального количества цветочков и маршрута
      Result result = findMaxFlowersWithRoute(field);
      System.out.println(result.maxFlowers);
      System.out.println(result.route);
  }

  private static class Result {
    int maxFlowers;
    String route;

    Result(int maxFlowers, String route) {
      this.maxFlowers = maxFlowers;
      this.route = route;
    }
  }

  private static Result findMaxFlowersWithRoute(int[][] field) {
    int n = field.length;
    int m = field[0].length;

    // Создаем массив для хранения максимального количества цветочков в каждой клетке
    int[][] maxFlowers = new int[n][m];
    // Создаем массив для хранения маршрута в каждой клетке
    char[][] route = new char[n][m];

    // Начальное значение в левом нижнем углу
    maxFlowers[n - 1][0] = field[n - 1][0];
    route[n - 1][0] = 'U';

    // Заполняем первый столбец (движение только вверх)
    for (int i = n - 2; i >= 0; i--) {
      maxFlowers[i][0] = maxFlowers[i + 1][0] + field[i][0];
      route[i][0] = 'U';
    }

    // Заполняем первую строку (движение только вправо)
    for (int j = 1; j < m; j++) {
      maxFlowers[n - 1][j] = maxFlowers[n - 1][j - 1] + field[n - 1][j];
      route[n - 1][j] = 'R';
    }

    // Заполняем остальные клетки
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 1; j < m; j++) {
        int up = maxFlowers[i + 1][j];
        int left = maxFlowers[i][j - 1];

        if (up > left) {
          maxFlowers[i][j] = up + field[i][j];
          route[i][j] = 'U';
        } else {
          maxFlowers[i][j] = left + field[i][j];
          route[i][j] = 'R';
        }
      }
    }

    // Восстановление маршрута
    StringBuilder path = new StringBuilder();
    int i = 0, j = m - 1;

    while (i < n - 1 || j > 0) {
      path.append(route[i][j]);
      if (route[i][j] == 'U') {
        i++;
      } else {
        j--;
      }
    }

    return new Result(maxFlowers[0][m - 1], path.reverse().toString());
  }
}
