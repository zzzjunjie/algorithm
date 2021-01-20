package 树.普通;

import 树.节点.TreeNode;

public class 删除给定值的叶子节点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root==null){
            return root;
        }

        TreeNode left = removeLeafNodes(root.left,target);

        TreeNode right = removeLeafNodes(root.right,target);

        if (left==null && right == null && target==root.val){
            return null;
        }

        root.left = left;
        root.right = right;
        return root;
    }
}
