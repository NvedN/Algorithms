package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_112 {

    public static void main(String[] args) {
//        hasPathSum(new TreeNode(5,
//                new TreeNode(4,
//                        new TreeNode(11,
//                                new TreeNode(7),
//                                new TreeNode(2)), null),
//
//                new TreeNode(8,
//                        new TreeNode(13), new TreeNode(4,
//                        new TreeNode(1), null))), 22);


        hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }
}

//              1
//            /  \
//          2      3
