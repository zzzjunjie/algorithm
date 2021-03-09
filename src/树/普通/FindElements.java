package 树.普通;

import 树.节点.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 * https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/
 */
public class FindElements {
    Set<Integer> memo = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val = val;
        memo.add(val);
        dfs(root.left, val * 2 + 1);
        dfs(root.right, val * 2 + 2);
    }

    public boolean find(int target) {
        return memo.contains(target);
    }
}
