package 树.普通;

import sun.reflect.generics.tree.Tree;
import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BSTIterator
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * 二叉搜索树迭代器
 */
public class BSTIterator {
    private TreeNode root ;
    Queue<TreeNode> queue = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        dfs(root.left);
        queue.offer(root);
        dfs(root.right);
    }

    public int next() {
        TreeNode poll = queue.poll();
        if (poll!=null){
            return poll.val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
