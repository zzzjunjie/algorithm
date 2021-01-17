package 树.普通;

import 树.节点.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class 二叉树中所有距离为k的结点 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> familyMap = new HashMap<>();
        //递归获取父子结点映射关系
        map(root, familyMap);
        boolean[] visited = new boolean[501];
        //递归获取距离指定结点指定距离的所有结点值
        search(target, K, res, visited, familyMap);
        return res;
    }

    private void map(TreeNode root, Map<TreeNode, TreeNode> familyMap) {
        if(root == null) return ;
        if(root.left != null) familyMap.put(root.left, root);
        if(root.right != null) familyMap.put(root.right, root);
        map(root.left, familyMap);
        map(root.right, familyMap);
    }

    private void search(TreeNode target, int K, List<Integer> res, boolean[] visited, Map<TreeNode, TreeNode> familyMap) {
        if(target == null || K < 0 || visited[target.val]) return;
        if(K == 0 && !visited[target.val]) {
            res.add(target.val);
            visited[target.val] = true;
            return;
        }
        visited[target.val] = true;
        search(target.left, K-1, res, visited, familyMap);
        search(target.right, K-1, res, visited, familyMap);
        search(familyMap.get(target), K-1, res, visited, familyMap);
    }
}
