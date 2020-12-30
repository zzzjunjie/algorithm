package 树;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        // 根节点入队列
        queue.offer(root);

       while (!queue.isEmpty()){
           List<Integer> val = new ArrayList<>();
           int currentSize = queue.size();
           for (int i = 0; i < currentSize; i++) {
               TreeNode poll = queue.poll();
               val.add(poll.val);
               if (poll.left!=null){
                   queue.offer(poll.left);
               }
               if (poll.right!=null){
                   queue.offer(poll.right);
               }
           }
           res.add(val);
       }
        return res;
    }
}
