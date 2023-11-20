package ru.nvn.interview.yandexContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Roman {

  public static int romanToInt(String s) {
    int result = 0;
    int[] arabicNumerals = new int[s.length()];
    HashSet<Character> alreadyUsed = new HashSet<>();
    Map<Character, Integer> max3 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if ('I' == s.charAt(i)) {
        arabicNumerals[i] = 1;
        if (checkMax3(max3, s.charAt(i))) {
          return -1;
        }
      } else if ('V' == s.charAt(i)) {
        arabicNumerals[i] = 5;
        if (alreadyUsed.contains(s.charAt(i))) {
          return -1;
        } else {
          alreadyUsed.add(s.charAt(i));
        }
      } else if ('X' == s.charAt(i)) {
        arabicNumerals[i] = 10;
        if (checkMax3(max3, s.charAt(i))) {
          return -1;
        }

      } else if ('L' == s.charAt(i)) {
        arabicNumerals[i] = 50;
        if (alreadyUsed.contains(s.charAt(i))) {
          return -1;
        } else {
          alreadyUsed.add(s.charAt(i));
        }

      } else if ('C' == s.charAt(i)) {
        arabicNumerals[i] = 100;

        if (checkMax3(max3, s.charAt(i))) {
          return -1;
        }

      } else if ('D' == s.charAt(i)) {
        arabicNumerals[i] = 500;
        if (alreadyUsed.contains(s.charAt(i))) {
          return -1;
        } else {
          alreadyUsed.add(s.charAt(i));
        }

      } else if ('M' == s.charAt(i)) {
        arabicNumerals[i] = 1000;

      } else {
        arabicNumerals[i] = 0;
      }
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

  public static boolean checkMax3(Map<Character, Integer> map, Character character) {
    if (map.containsKey(character)) {
      Integer alreadyAdded = map.get(character);
      if (alreadyAdded >= 2) {
        return true;
      }
      map.replace(character, 1 + alreadyAdded);
      return false;
    }
    map.put(character, 1);
    return false;
  }

  public static int convertToArabic(String number) {
    Map<Character, Integer> values = new HashMap<>();
    values.put('I', 1);
    values.put('V', 5);
    values.put('X', 10);
    values.put('L', 50);
    values.put('C', 100);
    values.put('D', 500);
    values.put('M', 1000);

    if (number == null || number.trim().isEmpty()) {
      return 0;
    }

    Map<Character, Integer> counts = new HashMap<>();
    for (char c : number.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }

    for (char c : counts.keySet()) {
      if (c == 'V' || c == 'L' || c == 'D') {
        if (counts.get(c) > 1) {
          return -1;
        }
      }
    }

    if (number.contains("XXXX")
        || number.contains("IIII")
        || number.contains("CCCC")
        || number.contains("MMMM")) {
      return -1;
    }

    String[] good = {"IV", "IX", "XL", "XC", "CD", "CM"};

    int res = 0;
    for (int i = 0; i < number.length(); i++) {
      if (i < number.length() - 1
          && values.get(number.charAt(i)) < values.get(number.charAt(i + 1))) {
        String check = number.substring(i, i + 2);
        boolean isValid = false;
        for (String g : good) {
          if (check.equals(g)) {
            isValid = true;
            break;
          }
        }
        if (!isValid) {
          return -1;
        }
        res -= values.get(number.charAt(i));
      } else {
        res += values.get(number.charAt(i));
      }
    }

    return res;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String romanNumber = reader.readLine().strip();
      System.out.println(convertToArabic(romanNumber));
    }
  }
}
