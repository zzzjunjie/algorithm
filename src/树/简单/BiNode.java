package 树.简单;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BiNode {
    //--------------------------------------------年轻写的- -垃圾代码效率贼低-------------------------------------------------------
    Queue<Integer> queue = new LinkedList<>();

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        TreeNode node = new TreeNode(queue.poll());
        TreeNode r = node;
        while (!queue.isEmpty()) {
            r.right = new TreeNode(queue.poll());
            r = r.right;
        }
        root = node;
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        queue.offer(root.val);
        dfs(root.right);
    }
    //--------------------------------------------年轻写的- -垃圾代码效率贼低 END-------------------------------------------------------


    TreeNode f;

    public TreeNode convertBiNode2(TreeNode root) {
        f = new TreeNode(Integer.MIN_VALUE);
        TreeNode pre = f;
        dfs2(root);
        return pre.right;
    }

    public void dfs2(TreeNode root) {
        if (root == null) return;
        dfs2(root.left);
        f.right = root;
        root.left = null;
        f = f.right;
        dfs2(root.right);
    }
}
