package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_92 {

    public static void main(String[] args) {
        System.out.println(reverseBetween(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right)
            return head;


        ListNode previousNodeOfLeft = null;
        ListNode nodeOfLeft = head;
        for (int i = 1; i < left; i++) {
            nodeOfLeft = nodeOfLeft.next;
            if (previousNodeOfLeft == null) {
                previousNodeOfLeft = head;
            } else {
                previousNodeOfLeft = previousNodeOfLeft.next;
            }
        }

        ListNode prev = previousNodeOfLeft;
        ListNode cur = nodeOfLeft;
        while (left <= right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            left++;
        }

        ListNode nodeOfRight = prev;
        ListNode nextNodeOfRight = cur;

        nodeOfLeft.next = nextNodeOfRight;
        if (previousNodeOfLeft == null) {
            head = nodeOfRight;
        } else {
            previousNodeOfLeft.next = nodeOfRight;
        }

        return head;
    }
}
