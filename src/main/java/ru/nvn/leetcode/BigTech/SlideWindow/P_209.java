package ru.nvn.leetcode.BigTech.SlideWindow;

public class P_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, answer = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        while (right < nums.length) {
            int n = nums[right];
            sum += n;
            count++;
            if (sum >= target) {
                answer = Math.min(answer, count);
                while (sum > target) {
                    left++;
                    sum -= nums[left - 1];
                    count--;

                    if (sum >= target) {
                        answer = Math.min(answer, count);
                    }
                }
            }
            right++;
        }


        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
