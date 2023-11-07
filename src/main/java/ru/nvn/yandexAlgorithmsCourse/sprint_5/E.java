package ru.nvn.yandexAlgorithmsCourse.sprint_5;

public class E {
  public static boolean treeSolution(Node head) {
    return isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBST(Node node, int minValue, int maxValue) {
    if (node == null) {
      return true;
    }
    if (node.value <= minValue || node.value >= maxValue) {
      return false;
    }
    return isBST(node.left, minValue, node.value) && isBST(node.right, node.value, maxValue);
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

    Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
  //     **/

  private static void test() {
    Node node1 = new Node(1, null, null);
    Node node2 = new Node(4, null, null);
    Node node3 = new Node(3, node1, node2);
    Node node4 = new Node(8, null, null);
    Node node5 = new Node(5, node3, node4);
    assert treeSolution(node5);
    node2.value = 5;
    assert !treeSolution(node5);
  }
}
