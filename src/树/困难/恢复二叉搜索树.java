package 树.困难;

import 树.节点.TreeNode;

import java.util.*;
// 未读
public class 恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;

        while (!stack.isEmpty() || root != null) {
            // 所有的左孩子入队列
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
