package ru.nvn.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

  //5 ms 43.9 mb
  public static int romanToInt(String s) {
    Map<Character, Integer> romanMap = new HashMap<>();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    int end = s.length() - 1;
    int arabian;
    int result = romanMap.get(s.charAt(end));
    for (int i = end - 1; i >= 0; i--) {
      arabian = romanMap.get(s.charAt(i));
      if (arabian < romanMap.get(s.charAt(i + 1))) {
        result -= arabian;
      } else {
        result += arabian;
      }
    }
    return result;
  }

  /// Fastest solution 2ms 43.7 mb
  public int romanToInt2(String s) {
    int result = 0;
    int[] arabicNumerals = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      arabicNumerals[i] =
              switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
              };
    }
    for (int i = 0; i < arabicNumerals.length; i++) {
      if (i < arabicNumerals.length - 1 && arabicNumerals[i] < arabicNumerals[i + 1]) {
        result += arabicNumerals[i + 1] - arabicNumerals[i];
        i++;
      } else {
        result += arabicNumerals[i];
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String romanNumber = reader.readLine().strip();
      System.out.println(romanToInt(romanNumber));
    }
  }
}
