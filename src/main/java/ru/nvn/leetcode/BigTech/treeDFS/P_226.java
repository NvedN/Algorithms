package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_226 {

    public static void main(String[] args) {
        invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))));
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode left = root.left;

        root.left = root.right;
        root.right = left;

        return root;
    }
}
