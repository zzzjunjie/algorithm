package 树.普通;

import jdk.nashorn.internal.runtime.arrays.IntOrLongElements;
import 树.节点.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 后继者 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        // 当前节点值小于等于目标值，那么当前目标值的后继者必然在右子树
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        // 否则结果有可能是当前节点，或者在当前节点的左子树中
        // 那么先去左子树找一下试试，找不到的话返回当前节点即是结果
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}
