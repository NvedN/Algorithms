package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_86 {

    public static void main(String[] args) {
        System.out.println(partition(new ListNode(4, new ListNode(3,
                new ListNode(2, new ListNode(5, new ListNode(2))))), 3));


//        System.out.println(partition(new ListNode(2, new ListNode(1)), 2));
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode left = before;
        ListNode right = after;

        while (head != null) {
            if (head.val < x) { // node smaller then x and those which are in order
//                left.next = head;
                left = left.next;
            } else { // node larger then x and those which are in order
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = after.next;
        return before.next;
    }
}
