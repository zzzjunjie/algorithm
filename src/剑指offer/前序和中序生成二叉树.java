package 剑指offer;

import 剑指offer.结构.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 前序和中序生成二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length,inorder,0,inorder.length-1,map);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (pStart > pEnd || iStart > iEnd){
            return null;
        }
        int obj = preorder[pStart];
        TreeNode res = new TreeNode(obj);
        int index = map.get(obj);
        res.left = helper(preorder,pStart+1,pStart+index-iStart,inorder,iStart,index-1,map);
        res.right = helper(preorder,pStart+index-iStart+1,pEnd,inorder,index+1,iEnd,map);
        return res;
    }
}
