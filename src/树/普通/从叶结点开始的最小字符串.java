package 树.普通;

import com.sun.org.apache.xpath.internal.operations.Or;
import 树.节点.TreeNode;

public class 从叶结点开始的最小字符串 {
    StringBuilder res = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        for (int i = 0; i < 8500; i++) {
            res.append("z");
        }
        dfs(root, String.valueOf((char) (root.val + 'a')));
        return res.toString();
    }
    private void dfs(TreeNode root, String str) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            StringBuilder temp = new StringBuilder(str);
            temp = temp.reverse();
            if (res.toString().compareTo(temp.toString()) > 0) {
                res = temp;
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left, str + (char) (root.left.val + 'a'));
        }
        if (root.right != null) {
            dfs(root.right, str + (char) (root.right.val + 'a'));
        }

    }

}
