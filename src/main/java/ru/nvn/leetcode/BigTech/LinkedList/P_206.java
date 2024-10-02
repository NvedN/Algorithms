package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_206 {



    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;

    }
}
