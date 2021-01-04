package 树;

import 树.节点.TreeNode;

public class 二叉树最长直径 {
    int max ;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        dep(root);
        return max;
    }

    public int dep (TreeNode root){
        if (root==null){
            return 0;
        }
        int left = dep(root.left)+1;
        int right = dep(root.right)+1;
        max = Math.max(max,left+right+1);
        return Math.max(left,right)+1;
    }






























//    int ans;
//    public int diameterOfBinaryTree(TreeNode root) {
//        ans = 1;
//        depth(root);
//        return ans - 1;
//    }
//        public int depth(TreeNode node) {
//            if (node == null) {
//                return 0; // 访问到空节点了，返回0
//            }
//            int L = depth(node.left); // 左儿子为根的子树的深度
//            int R = depth(node.right); // 右儿子为根的子树的深度
//            ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
//            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
//        }

}
