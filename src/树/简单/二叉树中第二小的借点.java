package 树.简单;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树中第二小的借点 {
    Queue<Integer> queue = new LinkedList<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        System.out.println(queue);
        int first = queue.poll();
        for (int i = 0; i < queue.size(); i++) {
            Integer poll = queue.poll();
            if (poll!=first){
                return poll;
            }
        }
        return -1;
    }

    public void dfs(TreeNode root){
        if (root==null) {
            return;
        }
        dfs(root.left);
        queue.offer(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
