package ru.nvn.leetcode.BigTech.LinkedList;


import ru.nvn.leetcode.BigTech.ListNode;

public class P_2 {


    public static void main(String[] args) {
        System.out.println(addTwoNumbers2(
                new ListNode(2, new ListNode(4, new ListNode(9))),

                new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))))));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = l1;

        String test = "";
        String test2 = "";

        ListNode prev2 = null;
        ListNode cur2 = l2;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            test = prev.val + test;
            cur = next;
        }

        while (cur2 != null) {
            ListNode next2 = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            test2 = prev2.val + test2;
            cur2 = next2;
        }

        int number = Integer.parseInt(test) + Integer.parseInt(test2);

        if (number == 0) {
            return new ListNode(0);
        }
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        while (number > 0) {
            int digit = number % 10;
            current.next = new ListNode(digit);
            current = current.next;
            number /= 10;
        }

        return dummy.next;
    }



    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

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
            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        if (carry == 1) pointer.next = new ListNode(1);
        return result.next;
    }
}
