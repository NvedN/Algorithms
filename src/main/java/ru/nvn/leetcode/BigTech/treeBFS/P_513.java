package ru.nvn.leetcode.BigTech.treeBFS;

import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_513 {

    public static void main(String[] args) {
        System.out.println(findBottomLeftValue(new TreeNode(2,
                new TreeNode(1, null, null), new TreeNode(3))));
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int answer = root.val; // Start with the root value
        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);

        while (!curLayer.isEmpty()) {
            List<TreeNode> nextLayer = new ArrayList<>();

            for (int i = 0; i < curLayer.size(); i++) {
                TreeNode node = curLayer.get(i);

                // Update answer only for the first node of the new layer
                if (i == 0) {
                    answer = node.val;
                }

                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }

            curLayer = nextLayer; // Move to the next layer
        }

        return answer; // This will be the leftmost value of the last row
    }

}
