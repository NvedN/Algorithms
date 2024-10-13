package ru.nvn.leetcode.BigTech.treeBFS;

import ru.nvn.leetcode.BigTech.Node;

import java.util.ArrayList;
import java.util.List;

public class P_116 {

    public static void main(String[] args) {
        connect(new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5),
                        null
                ),
                new Node(3,
                        new Node(6),
                        new Node(7),
                        null
                ),
                null
        ));
    }


    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        List<Node> curLayer = new ArrayList<>();
        curLayer.add(root);

        while (!curLayer.isEmpty()) {
            List<Node> nextLayer = new ArrayList<>();

            for (int i = 0; i < curLayer.size(); i++) {
                Node node = curLayer.get(i);
                if ( i + 1 < curLayer.size()) {
                    node.next = curLayer.get(i + 1);
                }
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
            curLayer = nextLayer;
        }

        return root;
    }
}
