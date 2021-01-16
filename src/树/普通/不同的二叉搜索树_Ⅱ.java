package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树_Ⅱ {
    public List<TreeNode> generateTrees(int n) {
        if (n<1){
            return new ArrayList<>();
        }

        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start>end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <=end ; i++) {
            for (TreeNode left : helper(start, i-1)) {
                for (TreeNode right : helper(i + 1, end)) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
