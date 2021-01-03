package 树;

import 树.节点.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 两数之和_IV {
    Map<Integer,Integer> map = new HashMap<>();
    boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode root,int k){
        if (root==null) {
            return;
        }
        int tmp = k - root.val;
        if (map.containsKey(tmp)){
            res = true;
            return;
        }else {
            map.put(root.val,tmp);
        }
        dfs(root.left,k);
        dfs(root.right,k);
    }
}
