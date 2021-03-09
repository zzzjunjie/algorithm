package 树.简单;

import 树.节点.TreeNode;

public class 二叉搜索树最小距离 {
//    int par=-1;
//    int min = Integer.MAX_VALUE;
//    public int minDiffInBST(TreeNode root) {
//        dfs(root);
//        return min;
//    }
//
//    public void dfs(TreeNode root){
//        if (root==null) {
//            return;
//        }
//        dfs(root.left);
//        if (par==-1) {
//            par = root.val;
//        }else{
//            int abs = Math.abs(root.val - par);
//            min = Math.min(min,abs);
//            par = root.val;
//        }
//        dfs(root.right);
//    }

    TreeNode node = null;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (node != null) {
            min = Math.min(Math.abs(node.val - root.val), min);
        }
        node = root;
        dfs(root.right);
    }

}
