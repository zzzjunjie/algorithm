package 树.困难;

import 树.节点.TreeNode;

public class 监控二叉树 {
    private int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (dfs(root) == 2) ans++;
        return ans;
    }

    // 0：该节点安装了监视器 1：该节点可观，但没有安装监视器 2：该节点不可观
    private int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 左右两边有一个监控不到就要安装监视器
        if (left == 2 || right == 2) {
            ans++;
            return 0;
        }
        // 左右两边其中一个安装了监视器，那该节点就可以被监视，可以不安装监视器
        if (left == 0 || right == 0) {
            return 1;
        }
        return 2;
    }
}
