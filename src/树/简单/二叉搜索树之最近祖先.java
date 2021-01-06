package 树.简单;

import 树.节点.TreeNode;

public class 二叉搜索树之最近祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        // 如果p q两个节点都比root的值要小，那么公共祖先一定在root的左边
        if (p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // 如果p q两个节点都比root的值要大，那么公共祖先一定在root的右边
        if (p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //除了上面两种情况，该root就是p q的公共祖先
        return root;
    }
}
