package ru.nvn.yandexAlgorithmsCourse.sprint_5;

public class C {
    public static boolean treeSolution(Node head) {
        if (head == null) {
            return true; // пустое дерево симметрично
        }
        return isSymmetric(head.left, head.right);
    }

    private static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) {
            return true; // если оба узла пустые, то они симметричны
        }
        if (left == null || right == null) {
            return false; // если только один узел пустой, то они несимметричны
        }
        if (left.value != right.value) {
            return false; // если значения узлов не равны, то они несимметричны
        }
        // сравниваем левый узел из левого поддерева с правым узлом из правого поддерева
        // и правый узел из левого поддерева с левым узлом из правого поддерева
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


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


    private static void test() {
        Node node1 = new Node(3,  null,  null);
        Node node2 = new Node(4,  null,  null);
        Node node3 = new Node(4,  null,  null);
        Node node4 = new Node(3,  null,  null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);
        assert treeSolution(node7);
    }

}
