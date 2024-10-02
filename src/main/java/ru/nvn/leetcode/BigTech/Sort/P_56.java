package ru.nvn.leetcode.BigTech.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_56 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}})));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Сортировка интервалов по начальной точке
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        // Начинаем с первого интервала
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];

            // Если интервалы пересекаются (начало текущего интервала <= конец предыдущего)
            if (interval[0] <= currentEnd) {
                // Объединяем интервалы, обновляя конец
                currentInterval[1] = Math.max(currentEnd, interval[1]);
            } else {
                // Если не пересекаются, добавляем новый интервал
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Преобразуем List в двумерный массив
        return merged.toArray(new int[merged.size()][]);
    }

}
