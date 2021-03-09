package 树.普通;

import 树.节点.TreeNode;

import java.util.*;

public class 两棵二叉搜索树中的所有元素 {
    List<Integer> set = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1, root2);
        Collections.sort(set);
        return set;
    }

    public void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return;
        }
        if (root1 != null) {
            set.add(root1.val);
        }
        if (root2 != null) {
            set.add(root2.val);
        }
        dfs(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        dfs(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
    }
}
