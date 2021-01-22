package 树.普通;

import 树.节点.TreeNode;

public class 找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original==null){
            return null;
        }
        if (original==target){
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left !=null) {
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);

    }
}
