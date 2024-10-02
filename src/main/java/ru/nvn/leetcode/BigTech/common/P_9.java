package ru.nvn.leetcode.BigTech.common;

public class P_9 {


    public static void main(String[] args) {

        System.out.println(isPalindrome(121));

    }


    public static boolean isPalindrome(int x) {
        String xS = String.valueOf(x);
        StringBuilder reverse = new StringBuilder();
        for (int a = xS.length(); a > 0; a--){
            reverse.append(xS.toCharArray()[a-1]);
        }
        return xS.contentEquals(reverse);
    }


}
