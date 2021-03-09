package 树.普通;

import 树.节点.TreeNode;

public class 二叉搜索树中第K小的元素 {
    /* 暴力破解 - -效率极低
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(res);
        return res.get(k-1);
    }

    public void dfs(TreeNode root){
        if (root==null) {
            return;
        }
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    */

    public int kthSmallest(TreeNode root, int k) {
        int lCount = findChild(root.left);
        if (lCount + 1 == k) {
            return root.val;
        }

        if (lCount >= k) {
            return kthSmallest(root.left, k);
        }
        return kthSmallest(root.right, k - lCount - 1);
    }

    public int findChild(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findChild(root.left) + findChild(root.right) + 1;
    }

}
