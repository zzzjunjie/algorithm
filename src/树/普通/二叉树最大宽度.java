package 树.普通;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import sun.reflect.generics.tree.Tree;
import 树.节点.TreeNode;

import javax.xml.stream.FactoryConfigurationError;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class 二叉树最大宽度 {
    /**
     * 层序遍历，记录每个节点的索引，当每层遍历完成后计算下一层的最大宽度(链表最后一个元素索引-链表的最前面元素索引+1)
     * 左子树的编号=父节点*2
     * 右子树的编号=父节点*2+1
     */
    private int maxW = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            int index = indexList.removeFirst();
            if (node.left != null) {
                queue.add(node.left);
                indexList.add(2 * index);
            }
            if (node.right != null) {
                queue.add(node.right);
                indexList.add(2 * index + 1);
            }
            if (size == 0) {
                if (indexList.size() >= 2) {
                    maxW = Math.max(maxW, indexList.getLast() - indexList.getFirst() + 1);
                }
                size = queue.size();
            }
        }

        return maxW;
    }
}
