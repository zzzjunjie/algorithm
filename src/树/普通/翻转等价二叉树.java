package 树.普通;

import 树.节点.TreeNode;

/**
 * https://leetcode-cn.com/problems/flip-equivalent-binary-trees/solution/fan-zhuan-deng-jie-er-cha-shu-by-leetcode/
 */
public class 翻转等价二叉树 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
    }
}
