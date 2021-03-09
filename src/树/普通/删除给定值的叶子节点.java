package 树.普通;

import 树.节点.TreeNode;

public class 删除给定值的叶子节点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }

        root.left = removeLeafNodes(root.left, target);

        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && target == root.val) {
            return null;
        }


        return root;
    }
}
