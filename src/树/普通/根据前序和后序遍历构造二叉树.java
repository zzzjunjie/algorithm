package 树.普通;

import 树.节点.TreeNode;

public class 根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,post,0,pre.length-1,0,post.length-1);
    }
    public TreeNode helper(int[] pre,int[] post,int prestart,int preend,int poststart,int postend){
        if(prestart>preend||poststart>postend)return null;
        TreeNode root=new TreeNode(pre[prestart]);
        if (prestart == preend)
            return root;
        int index=0;
        while(post[index]!=pre[prestart+1]){
            index++;
        }
        root.left=helper(pre,post,prestart+1,prestart+1+index-poststart,poststart,index);
        root.right=helper(pre,post,prestart+2+index-poststart,preend,index+1,postend-1);
        return root;

    }
}
