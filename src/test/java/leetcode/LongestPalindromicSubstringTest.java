package leetcode;

import org.junit.jupiter.api.Test;
import ru.nvn.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstringTest {

  @Test
  public void lengthOfLongestSubstring() {
    String result = LongestPalindromicSubstring.longestPalindrome("aacabdkacaa");
    System.out.println("----------result = " + result);
    assert result.equals("aca") || result.equals("aca");

  }
}
