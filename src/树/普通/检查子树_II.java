package 树.普通;

import 树.节点.TreeNode;

import java.util.Timer;

public class 检查子树_II {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        return dfs(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        boolean left = dfs(p.left, q.left);
        boolean right = dfs(p.right, q.right);
        return left && right;
    }
}
