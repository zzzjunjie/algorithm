package 树.普通;

import 树.节点.ListNode;
import 树.节点.TreeNode;

public class 二叉树中的列表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        return isSubPathFromRoot(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }
    //从根节点开始向下找
    private boolean isSubPathFromRoot(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        if (root.val == head.val)
            return isSubPathFromRoot(head.next, root.left) || isSubPathFromRoot(head.next, root.right);
        return false;
    }

}
