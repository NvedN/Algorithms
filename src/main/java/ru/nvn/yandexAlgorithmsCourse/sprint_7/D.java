package ru.nvn.yandexAlgorithmsCourse.sprint_7;

import java.util.Scanner;

public class D {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int mod = 1000000007;
    int[] f = new int[n + 1];

    f[0] = 1;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = (f[i - 1] + f[i - 2]) % mod;
    }

    System.out.println(f[n]);
  }
}
