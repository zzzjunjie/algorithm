package 树;



public class 平衡二叉树 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode node){
        return recur(node)!=-1;
    }

    public static int recur(TreeNode root){
        if (root==null) {
            return 0;
        }
        int left = recur(root.left);
        if (left==-1) {
            return -1;
        }
        int right = recur(root.right);
        if (right==-1) {
            return -1;
        }
        return Math.abs(left-right) <2?Math.max(left,right)+1:-1;
    }
}
