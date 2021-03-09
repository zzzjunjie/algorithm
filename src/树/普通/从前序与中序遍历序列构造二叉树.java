package 树.普通;

import 树.节点.TreeNode;

/*https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/*/
public class 从前序与中序遍历序列构造二叉树 {
    /**
     * 自己的解法
     * public TreeNode buildTree(int[] preorder, int[] inorder) {
     * if (preorder.length!=inorder.length){
     * throw new RuntimeException();
     * }
     * Map<Integer,Integer> map = new HashMap<>();
     * for (int i = 0; i < inorder.length; i++) {
     * map.put(inorder[i],i);
     * }
     * <p>
     * return buildTree(preorder,0,preorder.length-1,map,0,inorder.length-1);
     * }
     * <p>
     * private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
     * if (preLeft>preRight || inLeft>inRight){
     * return null;
     * }
     * <p>
     * TreeNode root = new TreeNode(preorder[preLeft]);
     * Integer pIdex = map.get(preorder[preLeft]);
     * root.left = buildTree(preorder,preLeft+1, pIdex - inLeft + preLeft,map,inLeft,pIdex-1);
     * root.right = buildTree(preorder,pIdex - inLeft + preLeft+1, preRight,map,pIdex+1,inRight);
     * return root;
     * }
     */

    /*大神的解法*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        //到达末尾返回 null
        if (pre == preorder.length) {
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //左子树的停止点是当前的根节点
        root.left = buildTreeHelper(preorder, inorder, root_val);
        //右子树的停止点是当前树的停止点
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }
}
