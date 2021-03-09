package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }

        int[] intRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            intRes[i] = res.get(i);
        }
        return intRes;
    }
}
