package ru.nvn.zero;

import java.io.IOException;
import java.util.Scanner;

public class A {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int x = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    System.out.println((a * x * x) + (b * x) + c);
  }
}
