package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_19 {


    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(
                new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,
                        new ListNode(5))))), 2));
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeNode = new ListNode(-1);
        ListNode slow = fakeNode, fast = fakeNode;
        fast.next = head;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;


        return head;

    }
}
