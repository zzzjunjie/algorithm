package 剑指offer.树;

import 剑指offer.结构.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */
// 根据先序遍历和中序表里构造二叉树
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int index = map.get(pre[preStart]);
        root.left = helper(pre, preStart + 1, index - inStart + preStart, in, inStart, index - 1, map);
        root.right = helper(pre, index - inStart + preStart + 1, preEnd, in, index+1, inEnd, map);
        return root;
    }


}
