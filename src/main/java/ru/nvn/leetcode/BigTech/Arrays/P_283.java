package ru.nvn.leetcode.BigTech.Arrays;

import java.util.Arrays;

public class P_283 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }


    // [0,1,0,3,12]
    // [1,3,12,0,0]

    // [1,3,12,0,0]

    public static int[] moveZeroes(int[] nums) {

        int a=0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]!=0){
                nums[a]=nums[i];
                a++;
            }

        }

        for(int i=a ; i<nums.length ; i++){
            nums[i]=0;
        }
        return nums;
    }
}

