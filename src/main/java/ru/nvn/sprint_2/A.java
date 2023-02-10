package ru.nvn.sprint_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class A {


  public static void main(String[] args) throws IOException {

    Scanner scan = new Scanner(System.in);
    int rows = scan.nextInt();
    int columns = scan.nextInt();
    if (rows == 0) {
      System.out.println();
    } else {
      int[][] matrix = readMatrix(scan, rows, columns);
      transposeMatrix(matrix, rows, columns);
    }

  }

  private static int[][] readMatrix(Scanner scanner, Integer rows,
      Integer columns) {

    int[][] a = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        a[i][j] = scanner.nextInt();
      }
    }
    return a;

  }

  public static void transposeMatrix(int[][] matrix, int n, int m) {

//    int n = matrix.length, m = matrix[0].length;
    // create empty transpose matrix of size m*n
    int[][] transposeMatrix = new int[m][n];

    // traverse matrix matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        //assign transposeMatrix[j][i] as matrix[i][j]
        transposeMatrix[j][i] = matrix[i][j];
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(transposeMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }


}
