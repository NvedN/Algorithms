package ru.nvn.leetcode.BigTech.treeBFS;

import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_102 {

    public static void main(String[] args) {

        System.out.println(levelOrder(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        )));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();


        if (root == null) {
            return answer;
        }

        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);

        while (!curLayer.isEmpty()) {
            List<TreeNode> nextLayer = new ArrayList<>();
            List<Integer> preAnswer = new ArrayList<>();

            for (TreeNode node : curLayer) {
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
                preAnswer.add(node.val);
            }
            answer.add(preAnswer);
            curLayer = nextLayer;
        }

        return answer;

    }
}
