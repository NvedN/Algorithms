package ru.nvn.leetcode.BigTech.SlideWindow;

public class P_643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, left = 0, right = k - 1;
        double answer = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        while (right != nums.length) {
            answer = Math.max(answer, (double) sum / k);
            right++;
            sum = sum - nums[left];
            left++;
            if (right != nums.length)
                sum = sum + nums[right];
        }
        return answer;
    }
}
