package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)
                        ),
                        new TreeNode(3)
                ),
                new TreeNode(2)
        );

        System.out.println(isBalanced(root));
    }

    private static boolean isBal = true;

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBal;
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftSub = maxDepth(node.left);
        int rightSub = maxDepth(node.right);
        if (Math.abs(leftSub - rightSub) > 1) {
            isBal = false;
        }
        return Math.max(leftSub, rightSub) + 1;
    }
}
