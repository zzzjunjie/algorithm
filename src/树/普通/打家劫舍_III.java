package 树.普通;

import 树.节点.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 解法：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
 */
public class 打家劫舍_III {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
//    Map<TreeNode, Integer> f = new HashMap<>();
//    Map<TreeNode, Integer> g = new HashMap<>();
//
//    public int rob(TreeNode root) {
//        dfs(root);
//        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
//    }
//
//    public void dfs(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        dfs(node.left);
//        dfs(node.right);
//        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
//        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
//    }
}
