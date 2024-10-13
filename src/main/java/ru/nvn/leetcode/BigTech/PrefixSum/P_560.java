package ru.nvn.leetcode.BigTech.PrefixSum;

import java.util.HashMap;

public class P_560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += map.computeIfAbsent(sum - k, key -> 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    // {1,1,1}   k = 2

    // 2;
}
