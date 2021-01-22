package 树.普通;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 最大层内元素和 {
    public int maxLevelSum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        int res = 0;
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            if (sum > max){
                res = level;
                max = sum;
            }
        }
        return res;
    }
}
