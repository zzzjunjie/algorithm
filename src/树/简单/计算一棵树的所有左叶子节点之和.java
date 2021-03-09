package 树.简单;

import 树.节点.TreeNode;

public class 计算一棵树的所有左叶子节点之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 判断是否为左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res = res + root.left.val;
        }
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
