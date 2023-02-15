package ru.nvn.sprint_2;

import java.io.IOException;

public class SolutionE {

  public static Node<String> solution(Node<String> head) {

    Node<String> previousNode = head;
    Node<String> nextNode = head.next;
    previousNode.next = null;
    previousNode.prev = nextNode;
    while (nextNode != null){
      nextNode.prev = nextNode.next;
      nextNode.next = previousNode;
      previousNode = nextNode;
      nextNode = nextNode.prev;
    }
    return previousNode;
    // Your code
    // ヽ(´▽`)/
  }

  public static void main(String[] args) throws IOException {

    Node<String> node3 = new Node<>("node3", null, null);
    Node<String> node2 = new Node<>("node2", node3, null);
    Node<String> node1 = new Node<>("node1", node2, null);
    Node<String> node0 = new Node<>("node0", node1, null);
    node1.prev = node0;
    node2.prev = node1;
    node3.prev = node2;
    Node<String> newNode = solution(node0);
    /* result is :*/
    assert newNode == node3;
    System.out.println("-------newNode = " + newNode.value);
    assert node3.next == node2;
    System.out.println("-------newNode = " + node3.next.value);

    assert node2.next == node1;
    System.out.println("----------node2 = " + node2.next.value);
    assert node2.prev == node3;
    System.out.println("----------node2 = " + node2.prev.value);
    assert node1.next == node0;
    System.out.println("----------node1 = " + node1.next.value);
    assert node1.prev == node2;
    System.out.println("----------node1 = " + node1.prev.value);
    assert node0.prev == node1;
    System.out.println("----------node0 = " + node0.prev.value);
  }

}
