package 树.普通;

import 树.节点.TreeNode;

public class 验证二叉搜索树_Ⅱ {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }


    public boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
