package ru.nvn.leetcode.BigTech.treeDFS;

import ru.nvn.leetcode.BigTech.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_113 {

    List<Integer> subAns = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ans;
        }
        answer(root, target);
        return ans;
    }
    public void answer(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        subAns.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            ans.add(new ArrayList<>(subAns));
        }
        answer(root.left, target - root.val);
        answer(root.right, target - root.val);
        subAns.remove(subAns.size() - 1);
    }
}
