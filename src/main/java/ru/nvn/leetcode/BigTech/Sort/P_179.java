package ru.nvn.leetcode.BigTech.Sort;

import java.util.Arrays;

public class P_179 {

    public static void main(String[] args) {

        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
//        3,30,34,5,9
        //"9534330"
    }

    public static String largestNumber(int[] nums) {

        String[] stringNumbers = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (stringNumbers[0].equals("0")) {
            return "0";
        }

        return String.join("", stringNumbers);
    }


}
