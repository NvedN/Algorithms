package ru.nvn.yandexAlgorithmsCourse.sprint_3;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    generateAllValidParentheses(n);
  }

  private static void generateAllValidParentheses(int n) {
    generateAllValidParentheses("", n, 0, 0);
  }

  private static void generateAllValidParentheses(String current, int n, int open, int close) {
    if (current.length() == 2 * n) {
      System.out.println(current);
      return;
    }

    if (open < n) {
      generateAllValidParentheses(current + "(", n, open + 1, close);
    }

    if (close < open) {
      generateAllValidParentheses(current + ")", n, open, close + 1);
    }
  }
}
