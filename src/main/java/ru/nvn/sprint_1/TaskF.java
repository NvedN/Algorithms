package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskF {

  private static boolean isPalindrome(String text) {

    String reverseLine = new StringBuilder(text.trim()).reverse()
        .toString();

    return reverseLine.equals(text);

  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String text = reader.readLine();
      if (isPalindrome(text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase())) {
        System.out.println("True");
      } else {
        System.out.println("False");
      }
    }
  }

}
