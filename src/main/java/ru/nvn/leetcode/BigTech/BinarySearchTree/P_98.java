package ru.nvn.leetcode.BigTech.BinarySearchTree;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_98 {

    public boolean isValidBST(TreeNode root) {
        // Start with the full range of allowable values for a BST
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        // Base case: if the node is null, it's valid
        if (root == null) return true;

        // Check the current node value against the allowable range
        if (root.val <= min || root.val >= max) return false;

        // Recursively validate the left subtree and right subtree
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }
}
