package ru.nvn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

  public static int lengthOfLongestSubstring(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    int maxLength = 0;
    int left = 0;
    int right = 0;
    Set<Character> charSet = new HashSet<>();
    while (right < s.length()) {
      if (!charSet.contains(s.charAt(right))) {
        charSet.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
        right++;
      } else {
        charSet.remove(s.charAt(left));
        left++;
      }
    }

    return maxLength;
  }
}
