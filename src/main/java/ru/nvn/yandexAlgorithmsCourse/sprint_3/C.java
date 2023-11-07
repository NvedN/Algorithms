package ru.nvn.yandexAlgorithmsCourse.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String s = readCharArray(reader);
      String t = readCharArray(reader);
      if (isSubsequence(s, t)) {
        System.out.println("True");
      } else {
        System.out.println("False");
      }
    }
  }

  public static boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

  private static String readCharArray(BufferedReader reader) throws IOException {
    return reader.readLine();
  }
}
