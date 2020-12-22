package 树;

import 树.节点.Node;

public class N叉树的遍历 {
    public static void func(Node root){
        if (root==null){
            return ;
        }
        // 先序遍历
        System.out.println(root.val);
        for (Node child : root.children) {
            func(child);
        }
        // 后序遍历
    }
}
