package 树.简单;

import 树.节点.TreeNode;

public class 根据二叉树创建字符串 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        // 左右子树都是null的情况不加括号
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        // 右子树是null的情况，把括号给左子树
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        // 两边都不为空 || 左儿子为null并且右儿子不为null
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
