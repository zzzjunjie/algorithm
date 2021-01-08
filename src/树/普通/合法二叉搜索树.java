package 树.普通;

import 树.节点.TreeNode;

public class 合法二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
      return dfs(root,null,null);
    }

    public boolean dfs(TreeNode root,Integer min,Integer max){
        if (root==null){
            return true;
        }
        if (min!=null && root.val <= min){
            return false;
        }
        if (max != null && root.val >= max){
            return false;
        }
        if (!dfs(root.left,min,root.val)){
            return false;
        }
        if (!dfs(root.right,root.val,max)){
            return false;
        }
        return true;
    }


    /**
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        return root == null || (root.val > min && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max));
    }*/
}
