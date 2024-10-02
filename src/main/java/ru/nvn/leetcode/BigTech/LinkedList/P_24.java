package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_24 {

    public static void main(String[] args) {
        System.out.println(swapPairs(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4))))));
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;

        while (cur.next != null && cur.next.next != null) {
            ListNode f = cur.next;
            ListNode s = cur.next.next;
            cur.next = s;
            f.next = s.next;
            s.next = f;
            cur = f;
        }
        return fake.next;

    }
}
