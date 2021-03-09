package 树.普通;

import 树.节点.TreeNode;

public class 最深叶节点的最近公共祖先 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == right) {
            return root;
        }
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }
}
