package 树.普通;
/*
* https://leetcode-cn.com/problems/maximum-binary-tree/
*/

import 树.节点.TreeNode;

public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int []nums,int pre,int end){
        if (pre > end){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = pre;
        for (int i = pre ;i<=end ;i++){
            if (max < nums[i]){
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left= dfs(nums, pre, index - 1);
        root.right= dfs(nums, index+1, end);
        return root;
    }
}
