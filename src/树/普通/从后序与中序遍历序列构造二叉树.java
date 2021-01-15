package 树.普通;

import 树.节点.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 从后序与中序遍历序列构造二叉树 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] post, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(post,0,post.length-1,0,inorder.length-1);
    }

    private TreeNode helper(int[] post, int postStart, int postEnd,int inorderStart, int inorderEnd) {
        if (postStart > postEnd || inorderStart > inorderEnd){
            return null;
        }

        TreeNode node = new TreeNode(post[postEnd]);
        if (postStart == postEnd){
            return node;
        }
        int index = map.get(post[postEnd-1]);
        node.left = helper(post,postStart,postStart+index-inorderStart,inorderStart,index);
        node.right = helper(post,postStart+index-inorderStart+1,postEnd-1,index+1,inorderEnd);
        return node;
    }
}
