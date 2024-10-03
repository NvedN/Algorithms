package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_113 {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


        List<List<Integer>> answer = new ArrayList<>();

//        answer.addAll();
        return null;
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
