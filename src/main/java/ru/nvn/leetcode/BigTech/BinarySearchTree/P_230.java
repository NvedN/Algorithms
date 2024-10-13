package ru.nvn.leetcode.BigTech.BinarySearchTree;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_230 {

//    public static void main(String[] args) {
//        System.out.println(kthSmallest(new TreeNode(5, new TreeNode(3,
//                new TreeNode(2,
//                        new TreeNode(1),
//                        null
//                ),
//                new TreeNode(4)
//        ),
//                new TreeNode(6)
//        ), 3));
//
////        System.out.println(kthSmallest(new TreeNode(1), 1));
//
////        System.out.println(kthSmallest(new TreeNode(3,
////                new TreeNode(1, null, new TreeNode(2)),
////                new TreeNode(4)), 1));
//    }
//

    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}
