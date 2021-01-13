package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 所有可能的满二叉树_II {
    Map<Integer,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();

        if (N==1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (map.containsKey(N)){
            return map.get(N);
        }
        // 只有单数才可能会构建成满二叉树
        if (N % 2 == 1){
            // i代表左边有多少个数去组成一棵树
            for (int i = 0; i < N; i++) {
                // Y代表右边有多少个数去组成一棵树
                int y = N - 1 - i;
                // 左子树集合
                List<TreeNode> left = allPossibleFBT(i);
                // 右子树集合
                List<TreeNode> right = allPossibleFBT(y);
                // 每一个左子树都和右子树对应一次，组成的集合就是N可以生成多少课满二叉树
                for (TreeNode lTree : left) {
                    for (TreeNode rTree : right) {
                        TreeNode tmp = new TreeNode(0);
                        tmp.left = lTree;
                        tmp.right = rTree;
                        res.add(tmp);
                    }
                }
            }
        }
        map.put(N,res);
        return res;
    }
}
