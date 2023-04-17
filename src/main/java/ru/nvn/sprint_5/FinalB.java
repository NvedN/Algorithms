// https://contest.yandex.ru/contest/24810/run-report/85926516/

package ru.nvn.sprint_5;

public class FinalB {

  /**
   * -- ПРИНЦИП РАБОТЫ -- 1.Если удаляемый узел является листом (не имеет потомков), его можно
   * просто удалить, изменив ссылку на него в родительском узле на null. 2.Если удаляемый узел имеет
   * одного потомка, то его потомок заменит его в дереве. 3.Если удаляемый узел имеет двух потомков,
   * то нужно найти узел, находящийся в левом поддереве, который будет следующим по порядку (имеет
   * наименьший ключ больший, чем удаляемый узел), и заменить удаляемый узел на этот узел. Затем
   * нужно удалить найденный узел из левого поддерева.
   *
   * <p>-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ -- Доказательство корректности этого алгоритма заключается в
   * том, что после каждого шага узел, который мы удаляем, не нарушает свойства бинарного дерева
   * поиска. После удаления узла, который имеет двух потомков, мы заменяем его на наименьший узел в
   * правом поддереве или наибольший узел в левом поддереве, и эти узлы также удовлетворяют
   * свойствам бинарного дерева поиска.
   *
   * <p>-- ВРЕМЕННАЯ СЛОЖНОСТЬ -- данного алгоритма удаления узла из бинарного дерева поиска равна
   * O(h), где h - высота дерева. В лучшем случае, когда дерево сбалансировано, высота будет равна
   * log(n), где n - количество узлов в дереве. В худшем случае, когда дерево является списком,
   * высота будет равна n, где n - количество узлов в дереве.
   *
   * <p>-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ -- данного алгоритма равна O(1), так как мы не используем
   * дополнительную память, кроме нескольких переменных.
   */
  public static Node remove(Node root, int key) {
    if (root == null) {
      return null;
    }
    if (key < root.getValue()) {
      root.setLeft(remove(root.getLeft(), key));
    } else if (key > root.getValue()) {
      root.setRight(remove(root.getRight(), key));
    } else {
      if (root.getLeft() == null) {
        return root.getRight();
      } else if (root.getRight() == null) {
        return root.getLeft();
      } else {
        Node minNode = findMin(root.getRight());
        root.setValue(minNode.getValue());
        root.setRight(remove(root.getRight(), minNode.getValue()));
      }
    }
    return root;
  }

  private static Node findMin(Node node) {
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node;
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
    Node node1 = new Node(null, null, 2);
    Node node2 = new Node(node1, null, 3);
    Node node3 = new Node(null, node2, 1);
    Node node4 = new Node(null, null, 6);
    Node node5 = new Node(node4, null, 8);
    Node node6 = new Node(node5, null, 10);
    Node node7 = new Node(node3, node6, 5);
    Node newHead = remove(node7, 10);
    assert newHead.getValue() == 5;
    assert newHead.getRight() == node5;
    assert newHead.getRight().getValue() == 8;
  }
}
