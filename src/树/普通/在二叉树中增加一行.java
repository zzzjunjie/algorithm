package 树.普通;

import 树.节点.TreeNode;

public class 在二叉树中增加一行 {
    /**
     public TreeNode addOneRow(TreeNode root, int v, int d) {
     if (d == 0 || d == 1) {
     TreeNode t = new TreeNode(v);
     if (d == 1) t.left = root;
     else t.right = root;
     return t;
     }
     if (root != null && d > 1) {
     root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
     root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
     }
     return root;
     }
     */
    /**
     public TreeNode addOneRow(TreeNode t, int v, int d) {
     if (d == 1) {
     TreeNode n = new TreeNode(v);
     n.left = t;
     return n;
     }
     insert(v, t, 1, d);
     return t;
     }

     public void insert(int val, TreeNode node, int depth, int n) {
     if (node == null)
     return;
     if (depth == n - 1) {
     TreeNode t = node.left;
     node.left = new TreeNode(val);
     node.left.left = t;
     t = node.right;
     node.right = new TreeNode(val);
     node.right.right = t;
     } else {
     insert(val, node.left, depth + 1, n);
     insert(val, node.right, depth + 1, n);
     }
     }*/
}
