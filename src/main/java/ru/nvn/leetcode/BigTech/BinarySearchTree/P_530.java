package ru.nvn.leetcode.BigTech.BinarySearchTree;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_530 {

    int mindiff;// global variable to track minDiff
    public int getMinimumDifference(TreeNode root) {
        mindiff=Integer.MAX_VALUE;//Setting minDiff initially as max
        inorder(root,Integer.MIN_VALUE);
        return  mindiff;
    }

    //we took inorder bcoz in bst inorder gives ascending sorting list in array
    private int inorder(TreeNode root, int prev){
        if(root==null)return prev;
        prev = inorder(root.left,prev);
        if(prev!=Integer.MIN_VALUE){
            mindiff=Math.min(mindiff,root.val-prev);
        }
        prev =root.val;
        prev=inorder(root.right,prev);
        return prev;
    }
}
