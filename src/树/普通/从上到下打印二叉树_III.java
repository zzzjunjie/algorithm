package 树.普通;

import sun.plugin.javascript.navig.Link;
import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flage = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (flage) {
                    ans.add(poll.val);
                } else {
                    ans.add(0, poll.val);

                }

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            flage = !flage;
            res.add(ans);
        }
        return res;
    }
}
