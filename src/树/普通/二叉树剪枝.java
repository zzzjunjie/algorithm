package 树.普通;

import 树.节点.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class 二叉树剪枝 {
    //------我真没想到这样写是可以的= =年轻的我也不知道
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null && right == null && root.val != 1) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }

}
