package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    int targe = 0;
    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        targe = sum;
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode root,int sum){
        if (root==null) {
            return ;
        }
        tmp.add(root.val);
        if (root.val+sum == targe && root.left==null &&root.right==null){
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left,sum + root.val);
        dfs(root.right,sum+root.val);
        for (int i = tmp.size()-1; i >=0 ; i++) {
            if (tmp.get(i) == root.val) {
                tmp.remove(i);
                break;
            }
        }
    }
}
