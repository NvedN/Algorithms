package ru.nvn.yandexAlgorithmsCourse.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class E {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    int maxLength = 0;
    int left = 0;
    Set<Character> uniqueChars = new HashSet<>();

    for (int right = 0; right < input.length(); right++) {
      char currentChar = input.charAt(right);

      while (uniqueChars.contains(currentChar)) {
        uniqueChars.remove(input.charAt(left));
        left++;
      }

      uniqueChars.add(currentChar);
      maxLength = Math.max(maxLength, right - left + 1);
    }

    System.out.println(maxLength);
  }
}
