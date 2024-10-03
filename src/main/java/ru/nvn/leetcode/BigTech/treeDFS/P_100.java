package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_100 {

    public static void main(String[] args) {

        isSameTree(
                new TreeNode(1, new TreeNode(2), new TreeNode(3))
                ,
                new TreeNode(1, new TreeNode(2), new TreeNode(3))
        );
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {


        if (p == null && q == null) {
            return true;
        }


        if (p == null || q == null || p.val != q.val) {
            return false;
        }


        var leftNext = isSameTree(p.left, q.left);
        var rightNext = isSameTree(p.right, q.right);

        return leftNext && rightNext;

    }
}
