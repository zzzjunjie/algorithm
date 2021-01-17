package 树.普通;

import sun.reflect.generics.tree.Tree;
import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树中所有距离为k的结点_Ⅱ {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        // 记录每一个节点的父节点位置
        dfs(root, map);
        List<Integer> res = new ArrayList<>();
        // 记录走过的父节点,题目提示了节点总数不超过500
        boolean[] isWalk = new boolean[501];
        search(target, res, K, isWalk, map);
        return res;
    }

    private void search(TreeNode target, List<Integer> res, int k, boolean[] isWalk, Map<TreeNode, TreeNode> map) {
        if (target == null || k < 0 || isWalk[target.val]) {
            return;
        }

        // 如果找到距离是0的k节点，并且这个节点没被记录过，那就把这个节点加入到结果集中
        if (k == 0 && !isWalk[target.val]) {
            res.add(target.val);
            // 设置走过的节点位置
            isWalk[target.val] = true;
            return;
        }

        // 设置走过的节点位置
        isWalk[target.val] = true;

        //左边搜索
        search(target.left, res, k - 1, isWalk, map);
        // 右边搜索
        search(target.right, res, k - 1, isWalk, map);
        // 父亲搜索
        search(map.get(target), res, k - 1, isWalk, map);
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }

        dfs(root.left, map);
        dfs(root.right, map);
    }
}
