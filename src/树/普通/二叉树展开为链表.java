package 树.普通;

import 树.节点.TreeNode;

public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = node;
    }


}
