package 树.普通;

import 树.节点.TreeNode;

public class 把二叉搜索树转换为累加树 {
    /**
     * 自己的第一个思路
     * List<Integer> list = new ArrayList<>();
     * public TreeNode convertBST(TreeNode root) {
     * dfs(root);
     * return help(root);
     * }
     * <p>
     * public TreeNode help(TreeNode root){
     * if (root==null){
     * return null;
     * }
     * int val = root.val;
     * for (Integer item : list) {
     * if (item>val) {
     * root.val += item;
     * }
     * }
     * root.left = help(root.left);
     * root.right = help(root.right);
     * return root;
     * }
     * <p>
     * public void dfs(TreeNode root){
     * if (root==null) {
     * return ;
     * }
     * <p>
     * dfs(root.left);
     * list.add(root.val);
     * dfs(root.right);
     * }
     */

    // 官方参考思路
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
