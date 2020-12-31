import 树.节点.TreeNode;

public class test {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if (p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if (p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
