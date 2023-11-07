package ru.nvn.yandexAlgorithmsCourse.sprint_5;

public class B {
  public static boolean treeSolution(Node head) {
    if (head == null) {
      return true; // пустое дерево считается сбалансированным
    }

    int heightDiff = getHeight(head.left) - getHeight(head.right);
    if (Math.abs(heightDiff) > 1) {
      return false; // высоты левого и правого поддеревьев отличаются более чем на 1
    } else {
      // проверяем сбалансированность левого и правого поддеревьев
      return treeSolution(head.left) && treeSolution(head.right);
    }
  }

  private static int getHeight(Node node) {
    if (node == null) {
      return -1; // высота пустого поддерева равна -1
    }
    return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }

  //    /** Comment it before submitting
  private static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  //     **/

  private static void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(-5);
    Node node3 = new Node(3);
    node3.left = node1;
    node3.right = node2;
    Node node4 = new Node(10);
    Node node5 = new Node(2);
    node5.left = node3;
    node5.right = node4;
    assert treeSolution(node5);
  }
}
