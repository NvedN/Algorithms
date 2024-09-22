package ru.nvn.leetcode;

import lombok.ToString;

public class Task_21 {

  public static void main(String[] args) {
    ListNode list1_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode list1_2 = new ListNode(1, new ListNode(3, new ListNode(4)));

    printList(mergeTwoLists(list1_1, list1_2));
    //    list1 = [1,2,4], list2 = [1,3,4]
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }

    if (l1 != null) {
      current.next = l1;
    }
    if (l2 != null) {
      current.next = l2;
    }

    return dummy.next;
  }

  // Helper method to print the linked list
  public static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }

  @ToString
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
