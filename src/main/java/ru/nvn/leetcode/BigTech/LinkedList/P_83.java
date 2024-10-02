package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P_83 {

    public static void main(String[] args) {

        deleteDuplicates(new ListNode(1,
                new ListNode(1, new ListNode(2, new ListNode()))));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // null|  1, 1, 1, 1, 2 , 3, 3
        //                  1, 2, 3,
        // null | 1, 1 , 2

        if (head == null || head.next == null) return head;
        ListNode s = head;
        ListNode f = head;
        while (f != null) {
            if (s.val != f.val) {
                s.next = f;
                s = s.next;
            }
            f = f.next;
        }
        s.next = null;
        return head;
    }


    public ListNode deleteDuplicates1(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            if (!set.contains(cur.val)) {
                set.add(cur.val);
                if (prev != null && prev.next == null) {
                    prev.next = cur;
                }
                prev = cur;
            } else {
                prev.next = null;
            }
            cur = next;

        }

        return head;
    }

}
