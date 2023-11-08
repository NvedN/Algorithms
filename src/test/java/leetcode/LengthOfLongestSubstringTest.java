package leetcode;

import org.junit.jupiter.api.Test;
import ru.nvn.leetcode.LengthOfLongestSubstring;

public class LengthOfLongestSubstringTest {

  @Test
  public void lengthOfLongestSubstring() {
    int result = LengthOfLongestSubstring.lengthOfLongestSubstring("dvdf");
    assert result == 3;
  }
}
