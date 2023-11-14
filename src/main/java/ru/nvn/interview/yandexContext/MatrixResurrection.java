package ru.nvn.interview.yandexContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixResurrection {
  private static int getLongestIncreasingPath(List<List<Integer>> matrix) {
    if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
      return 0;
    }

    int n = matrix.size();
    int m = matrix.get(0).size();
    int[][] dp = new int[n][m];
    int maxPathLength = 0;

    // Перебираем каждую клетку матрицы и запускаем поиск пути из нее
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int pathLength = findLongestPath(matrix, i, j, dp);
        maxPathLength = Math.max(maxPathLength, pathLength);
      }
    }

    return maxPathLength;
  }

  private static int findLongestPath(List<List<Integer>> matrix, int row, int col, int[][] dp) {
    if (dp[row][col] != 0) {
      return dp[row][col];
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int maxPathLength = 1;

    for (int[] dir : directions) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];

      if (newRow >= 0
          && newRow < matrix.size()
          && newCol >= 0
          && newCol < matrix.get(0).size()
          && matrix.get(newRow).get(newCol) > matrix.get(row).get(col)) {
        int pathLength = 1 + findLongestPath(matrix, newRow, newCol, dp);
        maxPathLength = Math.max(maxPathLength, pathLength);
      }
    }

    dp[row][col] = maxPathLength;
    return maxPathLength;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      List<List<Integer>> matrix = readMatrix(reader);
      System.out.println(getLongestIncreasingPath(matrix));
    }
  }

  private static List<List<Integer>> readMatrix(BufferedReader reader) throws IOException {
    String[] sizes = reader.readLine().strip().split(" ");
    int n = Integer.parseInt(sizes[0]);
    List<List<Integer>> matrix = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      matrix.add(readList(reader));
    }
    return matrix;
  }

  private static List<Integer> readList(BufferedReader reader) throws IOException {
    return Arrays.stream(reader.readLine().strip().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
