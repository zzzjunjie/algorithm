package 树.简单;

import 树.节点.TreeNode;

public class 二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        return myfun(root, root.val);
    }

    public int myfun(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = myfun(root.left, val);
        int r = myfun(root.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }
}
