package ru.nvn.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class TaskE {

  private static String getLongestWord(String text) {
    return Arrays.stream(text.split(" "))
        .max(Comparator.comparingInt(String::length))
        .orElse(null);
    // Ваше решение
  }
  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int textLength = readInt(reader);
      String text = reader.readLine();
      String longestWord = getLongestWord(text);
      System.out.println(longestWord);
      System.out.println(longestWord.length());
    }

  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

}
