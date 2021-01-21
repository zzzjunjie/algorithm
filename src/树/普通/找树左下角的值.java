package 树.普通;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值 {
    /**
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        if (root==null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i==0){
                    res = poll.val;
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }*/

    int max = Integer.MIN_VALUE;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int depth){
        if(node != null){
            if(node.left == null && node.right == null){
                if(max < depth){
                    max = depth;
                    res = node.val;
                }
            }
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }
}
