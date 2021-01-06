package 树;

import 树.节点.TreeNode;

import java.util.Timer;

public class 二叉树的坡度 {
    int res = 0;
    public int findTilt(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root==null)return 0;

        int left =  dfs(root.left);
        int right = dfs(root.right);
        res = res + Math.abs(left-right);
        return left + right +root.val;
    }


    public int findTilt2(TreeNode root) {
        if(root == null) return 0;
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt2(root.left) + findTilt2(root.right);
    }

    public int sum(TreeNode root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
