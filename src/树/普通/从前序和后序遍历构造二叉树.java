package 树.普通;

import 树.节点.TreeNode;

import javax.xml.stream.events.StartDocument;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class 从前序和后序遍历构造二叉树 {
//    public TreeNode constructFromPrePost(int[] pre, int[] post) {
//        return helper(pre,post,0,pre.length-1,0,post.length-1);
//    }
//    public TreeNode helper(int[] pre,int[] post,int prestart,int preend,int poststart,int postend){
//        if(prestart>preend||poststart>postend)return null;
//        TreeNode root=new TreeNode(pre[prestart]);
//        if (prestart == preend)
//            return root;
//        int index=0;
//        while(post[index]!=pre[prestart+1]){
//            index++;
//        }
//        root.left=helper(pre,post,prestart+1,prestart+1+index-poststart,poststart,index);
//        root.right=helper(pre,post,prestart+2+index-poststart,preend,index+1,postend-1);
//        return root;
//
//    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return node;
        }

        Integer index = map.get(pre[preStart + 1]);

        TreeNode left = helper(pre, preStart + 1, preStart + 1 + index - postStart, postStart, index);

        TreeNode right = helper(pre, preStart + 2 + index - postStart, preEnd, index + 1, postEnd);

        node.left = left;
        node.right = right;
        return node;
    }
}
