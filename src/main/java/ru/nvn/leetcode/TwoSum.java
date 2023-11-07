package ru.nvn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the length of the array: ");
    int n = scanner.nextInt();

    int[] nums = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      System.out.print("Element " + (i + 1) + ": ");
      nums[i] = scanner.nextInt();
    }

    System.out.print("Enter the target value: ");
    int target = scanner.nextInt();

    scanner.close();

    int[] result = twoSum(nums, target);

    if (result != null) {
      System.out.println(
              "Indices of the two numbers whose sum is equal to the target: "
                      + result[0]
                      + ", "
                      + result[1]);
    } else {
      System.out.println("No solution found.");
    }
  }

  public static int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numMap.containsKey(complement)) {
        return new int[]{numMap.get(complement), i};
      }
      numMap.put(nums[i], i);
    }
    return null;
  }
}
