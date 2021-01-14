package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉搜索树中第K小的元素 {
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(res);
        return res.get(k-1);
    }

    public void dfs(TreeNode root){
        if (root==null) {
            return;
        }
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
