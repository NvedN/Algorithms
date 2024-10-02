package ru.nvn.leetcode.BigTech.SlideWindow;

import java.util.HashMap;
import java.util.Map;

public class P_904 {
    public int totalFruit(int[] fruits) {
        int answer = 0, left = 0, right = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        while (right < fruits.length) {
            mpp.put(fruits[right], mpp.getOrDefault(fruits[right], 0) + 1);
            while (mpp.size() > 2) {
                mpp.put(fruits[left], mpp.get(fruits[left]) - 1);
                if (mpp.get(fruits[left]) == 0) {
                    mpp.remove(fruits[left]);
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}
