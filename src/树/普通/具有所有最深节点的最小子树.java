package 树.普通;

import 树.节点.TreeNode;

/**
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class 具有所有最深节点的最小子树 {
    /* 最垃圾的解法- - 现在出最深的那个节点，再把最深的那个节点遍历找到对应的树
    Map<TreeNode,Integer> map = new HashMap<>();
    int maxDepth = Integer.MIN_VALUE;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root,1);
        for (Integer value : map.values()) {
            maxDepth = Math.max(value,maxDepth);
        }
        return node(root);
    }

    public TreeNode node(TreeNode root){
        if (root==null || map.get(root) == maxDepth){
            return root;
        }

        TreeNode left = node(root.left);
        TreeNode right = node(root.right);
        if (left!=null && right!=null){
            return root;
        }
        if (left!=null){
            return left;
        }
        if (right!=null){
            return right;
        }
        return null;
    }

    public void dfs(TreeNode root,int level){
        if (root==null){
            return ;
        }
        map.put(root,level);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    */

    /** 大佬的解法 */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        int ldep = maxDepth(root.left), rdep = maxDepth(root.right);
        if (ldep == rdep)
            return root;
        else if (ldep > rdep)
            return subtreeWithAllDeepest(root.left);
        else
            return subtreeWithAllDeepest(root.right);

    }


    int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
