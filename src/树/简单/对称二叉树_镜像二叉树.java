package 树.简单;

import 树.节点.TreeNode;

public class 对称二叉树_镜像二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recue(root.left, root.right);
    }

    private boolean recue(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return recue(left.right, right.left) && recue(left.left, right.right);

    }
}
