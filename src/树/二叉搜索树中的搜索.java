package 树;

import 树.节点.TreeNode;

public class 二叉搜索树中的搜索 {
    TreeNode node = null;
    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root,val);
        return node;
    }

    public void dfs(TreeNode root,int val){
        if (root==null || node!=null){
            return;
        }
        if (root.val == val){
            node = root;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }


    /**
     * 递归
     */
    public TreeNode searchBST_2(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代
     */
    public TreeNode searchBST_3(TreeNode root, int val) {
        while (true) {
            if (root == null || root.val == val) return root;
            root = root.val > val ? root.left : root.right;
        }
    }
}
