package ru.nvn.leetcode.BigTech.BinarySearchTree;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_108 {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return addNode(nums, 0, nums.length - 1);
    }

    public static TreeNode addNode(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int middleIndex = left + ((right - left) / 2);
        TreeNode tree = new TreeNode(nums[middleIndex]);
        tree.left = addNode(nums, left, middleIndex - 1);
        tree.right = addNode(nums, middleIndex + 1, right);
        return tree;
    }
}
