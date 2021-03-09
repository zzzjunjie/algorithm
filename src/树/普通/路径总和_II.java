package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 路径总和_II {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> tmp = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, 0, targetSum);
        return res;
    }

    public static void dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            List<Integer> item = new ArrayList<>(tmp);
            res.add(item);
        }
        dfs(root.left, sum + root.val, targetSum);
        dfs(root.right, sum + root.val, targetSum);
        for (int i = tmp.size() - 1; i >= 0; i++) {
            if (tmp.get(i) == root.val) {
                tmp.remove(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> tmp = Arrays.asList(1, -2, -3, 1, 3, -2, null, -1);
        Queue<Integer> list = new LinkedList<>(tmp);
        TreeNode root = new TreeNode(list.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            Integer left = list.poll();
            Integer right = list.poll();
            if (left != null) {
                poll.left = new TreeNode(left);
            }
            if (right != null) {
                poll.right = new TreeNode(right);
            }

            queue.offer(poll.left);
            queue.offer(poll.right);
        }

        List<List<Integer>> lists = pathSum(root, 2);
        System.out.println(lists);
    }
}
