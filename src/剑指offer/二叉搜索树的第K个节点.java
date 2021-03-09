package 剑指offer;

import 剑指offer.结构.TreeNode;

public class 二叉搜索树的第K个节点 {
    /* 暴力破解
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
      // 遍历所有进行保存到list中
        dfs(root);
        // 找到k-1个
        return list.get(k-1);
    }

    public void dfs(TreeNode root){
        if (root==null){
            return ;
        }

        dfs(root.left);

        list.add(root.val);

        dfs(root.right);

    }
    */
    public int kthSmallest(TreeNode root, int k) {
        // 查找左子树节点总和
        int leftCount = find(root.left);
        if (leftCount == k - 1) {
            return root.val;
        }
        if (leftCount >= k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    public int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 返回左右两边节点个数总和
        return find(root.left) + find(root.right) + 1;
    }
}
