package ru.nvn.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    int[] ans = new int[] {0, 0};

    for (int i = 0; i < s.length(); i++) {
      System.out.println("----------i = " + i);
      System.out.println("----------s.charAt(I) = " + s.charAt(i));
      int oddLength = expand(i, i, s);
      if (oddLength > ans[1] - ans[0] + 1) {
        int dist = oddLength / 2;
        ans[0] = i - dist;
        ans[1] = i + dist;
      }

      int evenLength = expand(i, i + 1, s);
      if (evenLength > ans[1] - ans[0] + 1) {
        int dist = (evenLength / 2) - 1;
        ans[0] = i - dist;
        ans[1] = i + 1 + dist;
      }
    }

    System.out.println("----------ans = " + Arrays.toString(ans));
    int i = ans[0];
    int j = ans[1];
    return s.substring(i, j + 1);
  }

  private static int expand(int i, int j, String s) {
    System.out.println("------Expand");
    int left = i;
    int right = j;

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      System.out.println("----------left = " + s.charAt(left));
      System.out.println("----------right = " + s.charAt(right));
      left--;
      right++;
    }

    System.out.println("-------------------------------");
    return right - left - 1;
  }

  public static String longestPalindrome2(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int[] ans = new int[] {0, 0};

    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        ans[0] = i;
        ans[1] = i + 1;
      }
    }

    for (int diff = 2; diff < n; diff++) {
      for (int i = 0; i < n - diff; i++) {
        int j = i + diff;
        if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
          dp[i][j] = true;
          ans[0] = i;
          ans[1] = j;
        }
      }
    }

    int i = ans[0];
    int j = ans[1];
    return s.substring(i, j + 1);
  }

  public static String longestPalindrome3(String s) {

    if (s.length() == 1 || s.length() == 0) {
      return s;
    }
    String output = String.valueOf(s.charAt(0));
    for (int i = 0; i < s.length(); i++) {
      StringBuilder palindromString = new StringBuilder().append(s.charAt(i));
      char firstChar = s.charAt(i);
      for (int k = i + 1; k < s.length(); k++) {
        char secondChar = s.charAt(k);
        palindromString.append(secondChar);
        if (firstChar == secondChar && isPalindrom(palindromString.toString())) {
          output =
              palindromString.length() >= output.length() ? palindromString.toString() : output;
        }
      }
    }
    return output;
  }

  public static boolean isPalindrom(String s1) {
    return s1.equals(reverse(s1));
  }

  public static String reverse(String str) {
    // getBytes() method to convert string
    // into bytes[].
    byte[] strAsByteArray = str.getBytes();

    byte[] result = new byte[strAsByteArray.length];

    // Store result in reverse order into the
    // result byte[]
    for (int i = 0; i < strAsByteArray.length; i++)
      result[i] = strAsByteArray[strAsByteArray.length - i - 1];

    return new String(result);
  }
}
