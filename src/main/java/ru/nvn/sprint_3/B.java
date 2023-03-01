package ru.nvn.sprint_3;

import java.util.*;

public class B {

  private static Map<Character, String> phoneMap =
      new HashMap<Character, String>() {
        {
          put('2', "abc");
          put('3', "def");
          put('4', "ghi");
          put('5', "jkl");
          put('6', "mno");
          put('7', "pqrs");
          put('8', "tuv");
          put('9', "wxyz");
        }
      };

  private static void backtrack(
      String digits, int index, StringBuilder current, List<String> output) {
    if (index == digits.length()) {
      output.add(current.toString());
    } else {
      char digit = digits.charAt(index);
      String letters = phoneMap.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        current.append(letters.charAt(i));
        backtrack(digits, index + 1, current, output);
        current.deleteCharAt(index);
      }
    }
  }

  public static List<String> letterCombinations(String digits) {
    List<String> output = new ArrayList<String>();
    if (digits.length() != 0) {
      backtrack(digits, 0, new StringBuilder(), output);
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String digits = scanner.nextLine();
    List<String> combinations = letterCombinations(digits);
    for (String combination : combinations) {
      System.out.print(combination + " ");
    }
  }
}
