package 树;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 二叉搜索树中的众数 {
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if (root==null){
            return null;
        }
        dfs(root);
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            int temp = Math.max(max,value);
             if (temp == max){
                 res.add(key);
             }
             if (temp > max){
                 max = temp;
                 res = new ArrayList<>();
                 res.add(key);
             }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    public void dfs(TreeNode root){
        if (root==null){
            return ;
        }

        if (!map.containsKey(root.val)) {
          map.put(root.val,1);
        }else{
            Integer count = map.get(root.val);
            count++;
            map.put(root.val,count);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
