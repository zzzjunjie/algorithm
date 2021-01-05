package 树;

import 树.节点.TreeNode;

public class 二叉搜索树的范围和 {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return sum;
    }

    public void dfs(TreeNode root,int low,int high){
        if (root==null ){
            return ;
        }
        if (root.val>=low && root.val<=high){
            sum = sum + root.val;
        }
        if (root.val<low){
            dfs(root.right,low,high);
        }else if (root.val > high){
            dfs(root.left,low,high);
        }else {
            dfs(root.left,low,high);
            dfs(root.right,low,high);
        }
    }

    public int rangeSumBST_2(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if(root.val >= L && root.val <= R) {
            //当前节点再两数之间，把自身值加到结果里取，并往左右子节点递归
            return root.val + rangeSumBST(root.left, L ,R) + rangeSumBST(root.right, L , R);
        } else if(root.val < L){
            //当前节点小于L，往右子节点寻找
            return rangeSumBST(root.right, L, R);
        } else {
            //当前节点大于R，往左子节点寻找
            return rangeSumBST(root.left, L, R);
        }
    }
}
