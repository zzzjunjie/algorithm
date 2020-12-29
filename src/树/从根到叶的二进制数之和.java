package 树;

import 树.节点.TreeNode;

public class 从根到叶的二进制数之和 {
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        return 1;
    }

    public void sum(TreeNode root,int cur){
        if (root==null){
            return;
        }
        cur = cur*2 + root.val;
       sum(root.left,cur);
    }
}
