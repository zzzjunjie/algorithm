package 树.普通;

import 树.节点.TreeNode;

public class 求和路劲 {
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return 0;
//        }
//        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//
//    private int helper(TreeNode node, int sum) {
//        if (null == node) {
//            return 0;
//        }
//        sum -= node.val;
//        int count = sum == 0 ? 1 : 0;
//        count += helper(node.left, sum);
//        count += helper(node.right, sum);
//        return count;
//    }


    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        //这里不能在sum==0时直接return 1;
        // if(sum==0) return 1;
        return (sum == 0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
    }

}
