package 树.普通;

import 树.节点.TreeNode;

public class 最深叶节点的最近公共祖先_Ⅱ {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        //查找左边树的深度
        int left = dfs(root.left);
        //查找右子树的深度
        int right = dfs(root.right);
        //如果两边的深度相等的话，那么这个节点就是他们的最深公共父节点
        if (left == right) {
            return root;
        }
        //如果左边的要大于右边的，那最深公共父节点在左边
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }

    }

    // 计算深度
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(left, right) + 1;
    }
}
