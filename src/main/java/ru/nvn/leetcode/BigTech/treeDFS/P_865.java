package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

public class P_865 {

    public static void main(String[] args) {
        // Constructing the tree based on input array [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)
                )
        );

        System.out.println(subtreeWithAllDeepest(root));
    }

    static TreeNode ans;
    static int maxDepth = 0;

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {

        lca(root,0);
        return ans;
    }
    public static int lca(TreeNode root,int level) {

        if(root == null){
            return level;
        }

        int left = lca(root.left, level + 1);
        int right = lca(root.right, level + 1);

        if(left == right){
            maxDepth = Math.max(maxDepth, left);
            if(maxDepth == left){
                ans = root;
            }
        }
        return Math.max(left, right);
    }
}
