package 树.简单;

import 树.节点.TreeNode;

public class 单值二叉树 {
    int val = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (val == -1) {
            val = root.val;
        } else {
            if (root.val != val) {
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
