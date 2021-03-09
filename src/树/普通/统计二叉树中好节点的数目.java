package 树.普通;

import 树.节点.TreeNode;

public class 统计二叉树中好节点的数目 {

    int res = 0;
    int max = Integer.MIN_VALUE;

    public int goodNodes(TreeNode root) {
        max = root.val;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            res++;
        }
        int tmp = max;
        max = Math.max(max, root.val);
        dfs(root.left);
        dfs(root.right);
        max = tmp;
    }
}
