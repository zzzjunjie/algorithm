package 剑指offer;

public class 二叉搜索树的后序遍历序列 {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
             return helper(postorder,0,postorder.length-1);
        }

        private boolean helper(int[] postorder, int p, int q) {
            if (p >= q){
                return true;
            }
            int k = p;
            int v = postorder[q];
            while (postorder[k] < v){
                k++;
            }
            int m = k;
            while (postorder[k] > v){
                k++;
            }
            return k==q && helper(postorder,p,m-1) && helper(postorder,m,q-1);
        }
    }
}
