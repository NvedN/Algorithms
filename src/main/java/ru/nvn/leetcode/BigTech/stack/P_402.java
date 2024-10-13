package ru.nvn.leetcode.BigTech.stack;

import java.util.Stack;

public class P_402 {


//    Input: num = "1432219", k = 3
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (Character ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && ch < st.peek()) {
                st.pop();
                k--;
            }

            if (!st.isEmpty() || ch != '0') {
                st.push(ch);
            }
        }

        // This is a special edge case --> 1 2 3 4
        while (!st.isEmpty() && k-- > 0) {
            st.pop();
        }
        if (st.isEmpty())
            return "0";

        // Store the ans -->
        String ans = "";
        while (!st.isEmpty()) {
            ans = st.peek() + ans;
            st.pop();
        }
        return ans;
    }
}
