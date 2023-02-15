//package ru.nvn.sprint_2;
//
//import java.io.IOException;
//
//public class SolutionD {
//
//  public static int solution(Node<String> head, String elem) {
//
//    int count = 0;
//    while (head != null) {
//      if (head.value.equals(elem)) {
//        return count;
//      }
//      count++;
//      head = head.next;
//    }
//    return -1;
//    // Your code
//    // ヽ(´▽`)/
//  }
//
//
//  public static void main(String[] args) throws IOException {
//
//    Node<String> node3 = new Node<>("node3", null);
//    Node<String> node2 = new Node<>("node2", node3);
//    Node<String> node1 = new Node<>("node1", node2);
//    Node<String> node0 = new Node<>("node0", node1);
//    int idx = solution(node0, "node2");
//    System.out.println("----------idx = " + idx);
//    assert idx == 2;
//  }
//
//}
