package 腾讯50道精选;

public class 二叉搜索树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点与目标节点之一匹配，那么就可以返回，或者是走到最后一个节点的时候也可以返回
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    // 非递归的方式
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 根据二叉树的性质，如果root的值要比p、q都大，那么证明公共节点在左边
        // 如果root的值要比p、q都小，那么证明公共节点在右边
        // 如果root比p大，比q小或者root比p小，比q大，那么root就是公共父节点

        // 只有两边同为正 或者 两边同为负的时候相乘才为正，那么就会有两种情况，p、q在左边 或者 p、q在右边
        // 所以root节点要么往左边走，要么往右边走
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }

}
