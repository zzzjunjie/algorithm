package 树.普通;

import 树.节点.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int index = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(preorder, preStart + 1, index - inStart + preStart, inorder, inStart, index - 1);
        root.right = helper(preorder, index - inStart + preStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
