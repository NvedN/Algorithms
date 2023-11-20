package ru.nvn.interview.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
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

    // Вызов функции для поиска максимального количества цветочков
    int maxFlowers = findMaxFlowers(field);
    System.out.println(maxFlowers);
  }

  private static int findMaxFlowers(int[][] field) {
    int n = field.length;
    int m = field[0].length;

    // Создаем массив для хранения максимального количества цветочков в каждой клетке
    int[][] maxFlowers = new int[n][m];


    // Начальное значение в левом нижнем углу
    maxFlowers[n - 1][0] = field[n - 1][0];

    // Заполняем первый столбец (движение только вверх)
    for (int i = n - 2; i >= 0; i--) {
      System.out.println("----------field UP= " + field[i][0]);
      maxFlowers[i][0] = maxFlowers[i + 1][0] + field[i][0];
    }

    // Заполняем первую строку (движение только вправо)
    for (int j = 1; j < m; j++) {
      System.out.println("----------field RIGHT= " + field[n-1][j]);
      maxFlowers[n - 1][j] = maxFlowers[n - 1][j - 1] + field[n - 1][j];
    }

    System.out.println("----------maxFlowers = " + Arrays.deepToString(maxFlowers));

    // Заполняем остальные клетки
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 1; j < m; j++) {
        System.out.println("----------i = " + i);
        System.out.println("----------j = " + j);
        System.out.println("----------field = " + field[i][j]);
        maxFlowers[i][j] = Math.max(maxFlowers[i + 1][j], maxFlowers[i][j - 1]) + field[i][j];
      }
    }

    System.out.println("----------maxFlowers = " + Arrays.deepToString(maxFlowers));
    // Возвращаем максимальное количество цветочков в правом верхнем углу
    return maxFlowers[0][m - 1];
  }
}
