package ru.nvn.leetcode.BigTech.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

public class P_388 {

    public static void main(String[] args) {
        var a = "2";


        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }


    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // Initialize stack with 0 to avoid empty stack issues
        int maxLen = 0;
        String[] parts = input.split("\n");

        for (String part : parts) {
            int level = part.lastIndexOf("\t") + 1;  // Level is determined by the number of tabs
            while (level + 1 < stack.size()) {
                stack.pop();  // Pop until the stack matches the current level
            }
            int length = stack.peek() + part.length() - level + 1;  // Length includes '/'
            stack.push(length);

            if (part.contains(".")) {
                maxLen = Math.max(maxLen, length - 1);  // Update max length if part contains '.'
            }
        }
        return maxLen;
    }
}
