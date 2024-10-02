package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_142 {

    public static void main(String[] args) {
        detectCycle(new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4)))));
    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
