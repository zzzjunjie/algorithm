package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 所有可能的满二叉树 {
    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (memo.containsKey(N)){
            return memo.get(N);
        }
        List<TreeNode> list = new ArrayList<>();
        if (N == 1){
            list.add(new TreeNode(0));
            return list;
        }

        if (N % 2 ==1){
            for (int i = 0; i < N; i++) {
                int j = N - 1 - i;
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(j);

                for (TreeNode lTree : left) {
                    for (TreeNode rTree : right) {
                        TreeNode tmp = new TreeNode(0);
                        tmp.left = lTree;
                        tmp.right = rTree;
                        list.add(tmp);
                    }
                }
            }
            memo.put(N,list);
        }
        return list;
    }
}
