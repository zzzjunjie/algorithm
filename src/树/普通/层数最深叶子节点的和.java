package 树.普通;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class 层数最深叶子节点的和 {
    public int deepestLeavesSum(TreeNode root) {
        if (root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxLevel = Integer.MIN_VALUE;
        int res = 0;
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level>maxLevel){
                    res = 0;
                    maxLevel = level;
                }
                res += node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }


}
