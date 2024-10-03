package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_111 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null)
            return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return left == 0 || right == 0 ? 1 + left + right : Math.min(left, right) + 1;
    }
}
