package 树.普通;

import 树.节点.TreeNode;

public class 求根到叶子节点数字之和 {
    int sum = 0;
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        int left = sumNumbers(root.left);
        int right = sumNumbers(root.right);
        if (left == 0 && right == 0) {
            res = res + sum;
        }
        // 每一步都要回溯一下，恢复成上次的状态
        sum = (sum - root.val) / 10;
        return res;
    }
}
