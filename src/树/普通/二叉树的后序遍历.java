package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root==null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }
}
