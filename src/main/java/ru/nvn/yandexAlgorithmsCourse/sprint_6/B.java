package ru.nvn.yandexAlgorithmsCourse.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Считываем число вершин и число ребер
    String[] input = reader.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    // Создаем матрицу смежности и заполняем нулями
    int[][] adjacencyMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        adjacencyMatrix[i][j] = 0;
      }
    }

    // Считываем ребра и заполняем матрицу смежности
    for (int i = 0; i < m; i++) {
      input = reader.readLine().split(" ");
      int u = Integer.parseInt(input[0]) - 1; // Индексы вершин начинаются с 1, поэтому вычитаем 1
      int v = Integer.parseInt(input[1]) - 1;
      adjacencyMatrix[u][v] = 1;
    }

    // Выводим матрицу смежности
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(adjacencyMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
