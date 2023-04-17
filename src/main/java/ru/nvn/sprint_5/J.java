package ru.nvn.sprint_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class J {


  public static void main(String[] args) throws IOException {
    test();
  }

  public static Node insert(Node root, int key) {
    if (root == null) {
      return new Node(null, null, key);
    }
    if (key < root.value) {
      root.left = insert(root.left, key);
    } else {
      root.right = insert(root.right, key);
    }
    return root;
  }

  //    /** Comment it before submitting
  private static class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }
  //     **/

  private static void test() {
    Node node1 = new Node(null, null, 7);
    Node node2 = new Node(node1, null, 8);
    Node node3 = new Node(null, node2, 7);
    Node newHead = insert(node3, 6);
    System.out.println("----------newHead = " + newHead.getLeft().getValue() + " " + newHead.getRight().getValue() + "  " +newHead.getValue());
    System.out.println("----------node3 = " + node3.getLeft().getValue() + " " + node3.getRight().getValue() + "  " + node3.getValue());
    System.out.println("----------newHead.getLeft().getValue() = " + newHead.getLeft().getValue());
    assert newHead == node3;
    assert newHead.getLeft().getValue() == 6;
  }
}
