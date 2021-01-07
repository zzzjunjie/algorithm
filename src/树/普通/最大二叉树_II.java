package 树.普通;

import 树.节点.TreeNode;



public class 最大二叉树_II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null){
            TreeNode pre=new TreeNode(val);
            return pre;
        }
        if(val>root.val){
            TreeNode pre=new TreeNode(val);
            pre.left=root;
            return pre;
        }
        root.right=insertIntoMaxTree(root.right,val);
        return root;
    }
}
