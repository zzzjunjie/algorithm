package 树.普通;

import 树.节点.TreeNode;

public class 删除二叉搜索树的节点 {
    public TreeNode deleteNodeFromBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNodeFromBST(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNodeFromBST(root.right, key);
            return root;
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            /*如果 left 节点不为空，则找到 left 子树的最大值节点
             * 使 right 子树作为该节点的右子树
             * 如果 left 节点为空，则直接返回 right 节点即可*/
            if (left != null) {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = right;
                return root.left;
            } else {
                return right;
            }
        }
    }
}
