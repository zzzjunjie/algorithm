package 树.普通;

import sun.reflect.generics.tree.Tree;
import 树.节点.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/comments/
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 其中一个为null直接返回false
        if (A==null || B==null){
            return false;
        }
        // 查看由A为根节点，是否和B相匹配
        return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean dfs(TreeNode p, TreeNode q){
        if (q==null){
            return true;
        }
        if (p == null || p.val!=q.val){
            return false;
        }
        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }
}
