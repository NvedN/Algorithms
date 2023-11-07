package ru.nvn.yandexAlgorithmsCourse.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int a = readInt(reader);
      int b = readInt(reader);
      String s = reader.readLine();
      System.out.println(polynomialHash(s, a, b));
    }
  }

  public static long polynomialHash(String s, int a, int b) {
    long hash = 0;
    long power = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      hash = (hash + (s.charAt(i) * power) % b) % b;
      power = (power * a) % b;
    }
    return hash;
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static String readString(BufferedReader reader) throws IOException {
    return reader.readLine();
  }
}
