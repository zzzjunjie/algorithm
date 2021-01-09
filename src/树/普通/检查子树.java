package 树.普通;

import 树.节点.TreeNode;

import javax.swing.text.rtf.RTFEditorKit;

public class 检查子树 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1==null){
            return false;
        }
        return dfs(t1,t2) || checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }

    public boolean dfs(TreeNode p,TreeNode q){
        if (p==null && q==null){
            return true;
        }
        if (p==null){
            return false;
        }
        if (q == null){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }
}
