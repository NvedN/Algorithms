package ru.nvn.leetcode.BigTech.Sort;

import java.util.Arrays;

public class P_973 {

    public static void main(String[] args) {
//        points = [[1,3],[-2,2]], k = 1
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]));
        int[][] answer = new int[k][];
        for (int i = 0; i < k; i++) {
            answer[i] = points[i];
        }
        return answer;

    }
}
