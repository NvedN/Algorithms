package leetcode;

import org.junit.jupiter.api.Test;
import ru.nvn.leetcode.MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArraysTest {

  @Test
  public void findMedianSortedArrays() {
    double result =
        MedianOfTwoSortedArrays.findMedianSortedArrays(new int[] {1,3}, new int[] {2});
    System.out.println("----------result = " + result);
  }
}
