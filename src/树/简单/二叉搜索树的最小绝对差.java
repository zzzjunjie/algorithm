package 树.简单;

import 树.节点.TreeNode;

public class 二叉搜索树的最小绝对差 {
    private int result = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
        //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
        getMin(root);
        return result;
    }

    private void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (preNode != null) {
            result = Math.min(Math.abs(root.val - preNode.val), result);
        }
        preNode = root;
        getMin(root.right);
    }

//    Queue<Integer> queue = new LinkedList<>();
//    // 解题思路：可以进行一次中序遍历，得到一个已经排好序的数组，然后取其中最小的两个求差，最终就是结果
//    public int getMinimumDifference(TreeNode root) {
//        dfs(root);
//        Integer p1 = queue.poll();
//        Integer p2 = queue.poll();
//        int abs = Math.abs(p1 - p2);
//        return abs;
//    }
//
//    public void dfs (TreeNode root){
//        if (root==null){
//            return;
//        }
//        dfs(root.left);
//        queue.offer(root.val);
//        dfs(root.right);
//    }
}
