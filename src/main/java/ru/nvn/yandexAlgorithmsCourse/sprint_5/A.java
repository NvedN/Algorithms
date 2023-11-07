package ru.nvn.yandexAlgorithmsCourse.sprint_5;

public class A {
  public static int treeSolution(Node head) {
    if (head == null) {
      return Integer.MIN_VALUE; // Если дерево пустое, возвращаем минимальное значение int
    } else {
      int maxLeft =
          treeSolution(head.left); // Рекурсивно находим максимальное значение в левом поддереве
      int maxRight =
          treeSolution(head.right); // Рекурсивно находим максимальное значение в правом поддереве
      int maxChild =
          Math.max(maxLeft, maxRight); // Выбираем максимальное значение из двух поддеревьев
      return Math.max(
          head.value,
          maxChild); // Возвращаем максимальное значение из текущего узла и максимального значения
      // из поддеревьев
    }
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
    Node node4 = new Node(2);
    node4.left = node3;
    assert treeSolution(node4) == 3;
  }
}
