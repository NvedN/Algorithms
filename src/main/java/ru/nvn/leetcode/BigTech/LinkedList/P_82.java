package ru.nvn.leetcode.BigTech.LinkedList;

import ru.nvn.leetcode.BigTech.ListNode;

public class P_82 {

    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(3, new ListNode(4,
                                new ListNode(4, new ListNode(5))))))));
    }


    public static ListNode deleteDuplicates(ListNode head) {

//        Input: head = [1,2,3,3,3,3,4,4,5]
//              s            |
//              f                |
//              p          |

//        Output: [1,2,5]
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = head;
        ListNode prev = newHead;

        while (curr != null) {
            boolean isDuplicate = false;
            while (curr.next != null && curr.val == curr.next.val) {
                isDuplicate = true;
                curr = curr.next;
            }
            if (isDuplicate) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return newHead.next;
    }
}
