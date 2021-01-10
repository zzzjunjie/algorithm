package 树.普通;

import sun.reflect.generics.tree.Tree;
import 树.节点.TreeNode;

import javax.crypto.interfaces.PBEKey;
import javax.swing.text.rtf.RTFEditorKit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 删点成林 {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return res;
        }
        for (int i : to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)) {
            res.add(root);
        }
        dfs(root);
        return res;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = dfs((root.left));
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
