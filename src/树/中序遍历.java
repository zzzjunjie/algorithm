package 树;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        // 镜进行中序遍历，把值放入vals中
        inorder(root, vals);
        // 初始化一棵树，将vals中的值全部连接起来并且返回
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
}
