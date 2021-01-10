package 树.普通;

import 树.节点.TreeNode;

import java.util.HashMap;
import java.util.Map;
/*https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/*/
public class 从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length!=inorder.length){
            throw new RuntimeException();
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0,preorder.length-1,map,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft>preRight || inLeft>inRight){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        Integer pIdex = map.get(preorder[preLeft]);
        root.left = buildTree(preorder,preLeft+1, pIdex - inLeft + preLeft,map,inLeft,pIdex-1);
        root.right = buildTree(preorder,pIdex - inLeft + preLeft+1, preRight,map,pIdex+1,inRight);
        return root;
    }
}
