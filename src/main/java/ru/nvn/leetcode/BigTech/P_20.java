package ru.nvn.leetcode.BigTech;

import java.util.Stack;

public class P_20 {


    public static void main(String[] args) {

        System.out.println(isValid("([])"));

    }


    public static boolean isValid(String s) {

//        (  [  ]  )

        Stack<Character> stack = new Stack<>() ;
        for(int i =0; i < s.length(); i++){
            stack.push(s)
        }
        return true;
    }
}
