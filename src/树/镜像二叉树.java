package 树;

import 树.节点.TreeNode;

public class 镜像二叉树 {
    // 先序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(right);
        return root;
    }


    public TreeNode mirrorTree2(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(right);
        return root;
    }
}
