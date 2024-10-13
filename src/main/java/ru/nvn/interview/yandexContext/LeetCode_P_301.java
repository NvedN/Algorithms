package ru.nvn.interview.yandexContext;

import ru.nvn.leetcode.BigTech.ListNode;
import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.Stack;

public class LeetCode_P_301 {

//    public List<String> removeInvalidParentheses(String s) {
//
//        Stack<Character> stack = new Stack<>();
//
//        for(Character c : s.toCharArray()){
//
//
//        }
//
//    }


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }


        if (p == null || q == null || p.val != q.val) {
            return false;
        }


        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left || right;


    }


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;

    }


//    public static void main(String[] args) {
//        System.out.println(addTwoNumbers(
//                new ListNode(2, new ListNode(4, new ListNode(9))),
//
//                new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))))));
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        int carry = 0;

        ListNode ptr = result;

        while (l1 != null || l2 != null) {
            int sum = 0 + carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            sum = sum % 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }


        return result.next;
    }


    //    Input: nums = [-1,0,3,5,9,12], target = 9
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }


//    public int guessNumber(int n) {
//        int start = 0;
//        int end = n;
//        while(start <= end){
//            int mid = start + (end - start) / 2;
//            if(guess(mid) == -1) end = mid - 1;
//            else if(guess(mid) == 1) start = mid + 1;
//            else return mid;
//        }
//        return 0;
//    }


//    nums.length / 2;
//    index 2 = 3. 3 == 9 ?
//
//
//

//    Input: s = "([])"


    public static void main(String[] args) {
        System.out.println(isValid2("[]()[{()()]}()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();

            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

//    '(', ')', '{', '}', '[' and ']',
}
