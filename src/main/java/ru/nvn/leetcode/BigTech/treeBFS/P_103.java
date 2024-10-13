package ru.nvn.leetcode.BigTech.treeBFS;

import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_103 {

    public static void main(String[] args) {

        System.out.println(levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();


        if (root == null) {
            return answer;
        }

        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);

        boolean order = true;

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
                if (order) {
                    preAnswer.add(node.val);
                }
            }

            if (!order) {
                for (int i = curLayer.size() - 1; i >= 0; i--) {
                    preAnswer.add(curLayer.get(i).val);
                }
            }

            answer.add(preAnswer);
            curLayer = nextLayer;
            order = !order;
        }

        return answer;

    }
}
