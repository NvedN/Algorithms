package ru.nvn.leetcode.BigTech.treeBFS;

import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_199 {

    public static void main(String[] args) {
        rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))));
    }


    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        if (root == null) {
            return answer;
        }
        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);

        while (!curLayer.isEmpty()) {
            answer.add(curLayer.get(curLayer.size() - 1).val);

            List<TreeNode> nextLayer = new ArrayList<>();

            for (TreeNode node : curLayer) {
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
            curLayer = nextLayer;
        }
        return answer;
    }
}
