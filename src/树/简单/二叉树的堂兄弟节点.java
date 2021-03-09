package 树.简单;

import 树.节点.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 二叉树的堂兄弟节点 {
    Map<Integer, Integer> dep;
    Map<Integer, TreeNode> par;

    public boolean isCousins(TreeNode root, int x, int y) {
        dep = new HashMap<>();
        par = new HashMap<>();
        dfs(root, null);
        return (par.get(x) != par.get(y)) && (dep.get(x).equals(dep.get(y)));
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dep.put(root.val, p == null ? 1 : dep.get(p.val) + 1);
        par.put(root.val, p);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    //--------解法2-----------
//    int xpar, xdep, ypar, ydep;
//
//    public boolean isCousins(TreeNode root, int x, int y) {
//        dfs(root.left, 1, x, y, root.val);
//        dfs(root.right, 1, x, y, root.val);
//        return (xpar != ypar) && (xdep == ydep);
//    }
//
//    public void dfs(TreeNode node, int dep, int x, int y, int par) {
//        if (node == null) {
//            return;
//        }
//        if (node.val == x) {
//            xpar = par;
//            xdep = dep;
//        } else if (node.val == y) {
//            ypar = par;
//            ydep = dep;
//        } else {
//            dfs(node.left, dep+1, x, y, node.val);
//            dfs(node.right, dep+1, x, y, node.val);
//        }
//    }
}
