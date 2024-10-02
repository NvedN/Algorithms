package ru.nvn.leetcode.BigTech.Arrays;

import java.util.ArrayList;
import java.util.List;

public class P_442 {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{0,1,1,0}));
    }


    //1,3,4,3,2

    // [-1,3,-4,3,2]
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (nums[value - 1] > 0) {
                nums[value - 1] *= -1;
            } else {
                answer.add(value);
            }
        }

        return answer;
    }
}
