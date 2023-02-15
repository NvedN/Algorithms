//package ru.nvn.sprint_2;
//
//import java.io.IOException;
//
//public class SolutionC {
//
//  public static Node<String> solution(Node<String> head, int idx) {
//    if(idx == 0){
//      return head.next;
//    }
//
//
//    Node<String> previousNode = getNodeByIndex(head,idx-1);
//
//    previousNode.next = getNodeByIndex(head,idx+1);
//    return head;
//    // Your code
//    // ヽ(´▽`)/
//  }
//
//  private static Node<String> getNodeByIndex(Node<String> head, int idx) {
//    while(idx >0){
//      head = head.next;
//      idx--;
//    }
//    return head;
//  }
//
//  public static void main(String[] args) throws IOException {
//
//    Node<String> node3 = new Node<>("node3", null);
//    Node<String> node2 = new Node<>("node2", node3);
//    Node<String> node1 = new Node<>("node1", node2);
//    Node<String> node0 = new Node<>("node0", node1);
//    Node<String> newHead = solution(node0, 1);
//    System.out.println("-----new head = " + newHead.value);
//    System.out.println("-----new head = " + newHead.next.value);
//    System.out.println("-----new head = " + newHead.next.next.value);
//    System.out.println("-----new head = " + newHead.next.next.next.value);
//
//    assert newHead == node0;
//    assert newHead.next == node2;
//    assert newHead.next.next == node3;
//    assert newHead.next.next.next == null;
//    // result is : node0 -> node2 -> node3
//  }
//
//}
