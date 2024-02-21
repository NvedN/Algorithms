package ru.nvn.interview.tinkoff;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class task2 {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    System.out.println(Arrays.deepToString(fillMatrix(n, m)));
  }

  private static int[][] fillMatrix(int n, int m) {
    int count = n * m;
    int[][] grid = new int[n][m];
    int num = 1;

    for (int i = 0; i < n + m - 1; i++) {
      for (int j = 0; j <= i; j++) {
        if (j < n && i - j < m) {
          grid[j][i - j] = num++;
          System.out.println("------j = " + j);
          System.out.println("----------grid = " + Arrays.deepToString(grid));
        }
      }
    }

    return grid;
  }
}
