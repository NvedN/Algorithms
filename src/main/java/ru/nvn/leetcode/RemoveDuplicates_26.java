package ru.nvn.leetcode;

import java.util.HashSet;

public class RemoveDuplicates_26 {

  public static void main(String[] args) {
    removeDuplicates(new int[] {1, 1, 2});

    int[] nums = new int[] {1, 1, 2}; // Input array
    int[] expectedNums = new int[2]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
      assert nums[i] == expectedNums[i];
    }
    System.out.println("---Here?");
    //
  }

  public static int removeDuplicates(int[] nums) {
    HashSet<Integer> uniqNums = new HashSet<>();
    for (int num : nums) {
      uniqNums.add(num);
    }
    System.out.println("----------uniqNums = " + uniqNums);
    System.out.println("----------uniqNums = " + uniqNums.size());

    return uniqNums.size();
  }

  public static int removeDuplicates2(int[] nums) {
    int j = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[j] = nums[i];
        j++;
      }
    }
    System.out.println("----------j = " + j);
    return j;
  }
}
