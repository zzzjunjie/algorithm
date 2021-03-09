package 树.普通;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 前序遍历构造二叉搜索树 {
    /*自己的解法
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length<=0){
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i : preorder) {
            queue.offer(i);
        }
        TreeNode res = new TreeNode(queue.poll());
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            insert(res,poll);
        }
        return res;
    }

    public void insert(TreeNode root,int v){
        if (root==null){
            return;
        }
        if (root.val > v && root.left ==null){
            root.left = new TreeNode(v);
            return ;
        }
        if (root.val < v && root.right ==null){
            root.right = new TreeNode(v);
            return ;
        }
        if (root.val > v){
            insert(root.left,v);
        }else{
            insert(root.right,v);
        }
    }*/
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = add(root, preorder[i]);
        }
        return root;
    }

    public TreeNode add(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (root.val > num) {
            root.left = add(root.left, num);
        } else {
            root.right = add(root.right, num);
        }
        return root;
    }
}
