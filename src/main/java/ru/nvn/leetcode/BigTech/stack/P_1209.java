package ru.nvn.leetcode.BigTech.stack;

import java.util.HashMap;
import java.util.Stack;

public class P_1209 {

    public static void main(String[] args) {

        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }

    //   |
    //   pbbcggttciiippooaais , k = 3
    //                 |
    //   ppp  tmp = p  map p-1
    // dj
//    public static String removeDuplicates(String s, int k) {
//
//        Stack<Character> stack = new Stack<>();
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (Character c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            if (!stack.isEmpty() && stack.peek() != c) {
//                if (map.get(stack.peek()) >= k) {
//                    char tmp = stack.peek();
//                    int count = map.get(tmp);
//                    while (!stack.isEmpty() && stack.peek() == tmp && count!=0) {
//                        stack.pop();
//                        map.computeIfPresent(tmp, (key, val) -> val - 1);
//                        count--;
//                    }
//                    if(map.get(tmp) == 0){
//                        map.remove(tmp);
//                    }
//                }
//            }
//            stack.push(c);
//        }
//
//        if (map.get(stack.peek()) > k) {
//            char tmp = stack.peek();
//            while (stack.peek() == tmp) {
//                stack.pop();
//            }
//        }
//
//        StringBuilder output = new StringBuilder();
//
//        while(!stack.isEmpty()){
//            output.append(stack.pop());
//        }
//
//        return output.reverse().toString();
//    }

    public static String removeDuplicates(String s, int k) {

        // Stack to hold pairs of (character, count)
        Stack<Pair> stack = new Stack<>();

        // Traverse the string character by character
        for (char c : s.toCharArray()) {

            // If the stack is not empty and the top element has the same character
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;  // Increase the count
                if (stack.peek().count == k) {  // If count reaches k, remove the pair
                    stack.pop();
                }
            } else {
                // Otherwise, push a new pair with count 1
                stack.push(new Pair(c, 1));
            }
        }

        // Build the final result string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            result.append(String.valueOf(p.character).repeat(p.count));
        }

        // Return the reversed string because we processed it in reverse order
        return result.reverse().toString();
    }

    // Helper class to hold character and its consecutive count
    static class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}
