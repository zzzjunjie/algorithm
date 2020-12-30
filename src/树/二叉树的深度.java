package 树;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的深度 {
    // 解法1：使用BFS进行遍历
    public int maxDepth(TreeNode root) {
        // 根节点为null没有深度
        if (root==null){
            return 0;
        }
        // 让根节点入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 创建一个临时队列，用来保存每一层的节点
        Queue<TreeNode> tmp ;
        // 保存深度
        int dep = 0;
        //如果队列不为空则一直循环
        while (queue.size()>0){
            // 初始化tmp队列
            tmp = new LinkedList<>();
            // 将队列里面所有的左右儿子放入临时队列
            for (TreeNode item : queue) {
                if (item.left!=null){
                    tmp.offer(item.left);
                }
                if (item.right!=null){
                    tmp.offer(item.right);
                }
            }
            dep ++;
            queue = tmp;
        }
        return dep;
    }

    // 解法2：使用DFS进行遍历
    int maxDep = 0;
    public int maxDepth2(TreeNode root){
        if (root==null){
            return  maxDep;
        }
        maxDep++;
        int leftDep = maxDepth2(root.left);
        maxDep = 0;
        int rightDep = maxDepth2(root.right);
        return Math.max(leftDep,rightDep);
    }
}
