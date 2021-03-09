package 树.简单;


import 树.节点.TreeNode;

public class 平衡二叉树 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode node) {
        return recur(node) != -1;
    }

    public static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //先计算左边树的深度
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        // 计算右边树的深度
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        // 左右两边深度做相差大于1就返回-1 否则返回他们的最大深度
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
