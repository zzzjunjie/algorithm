package 树.普通;

import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/submissions/
 */
public class 好叶子节点对的数量 {
    /* 官方解题
    public int countPairs(TreeNode root, int distance) {
        Pair pair = dfs(root, distance);
        return pair.count;
    }

    // 对于 dfs(root,distance)，同时返回：
    // 1）每个叶子节点与 root 之间的距离
    // 2) 以 root 为根节点的子树中好叶子节点对的数量
    public Pair dfs(TreeNode root, int distance) {
        int[] depths = new int[distance + 1];
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) {
            depths[0] = 1;
            return new Pair(depths, 0);
        }

        int[] leftDepths = new int[distance + 1];
        int[] rightDepths = new int[distance + 1];
        int leftCount = 0, rightCount = 0;
        if (root.left != null) {
            Pair leftPair = dfs(root.left, distance);
            leftDepths = leftPair.depths;
            leftCount = leftPair.count;
        }
        if (root.right != null) {
            Pair rightPair = dfs(root.right, distance);
            rightDepths = rightPair.depths;
            rightCount = rightPair.count;
        }

        for (int i = 0; i < distance; i++) {
            depths[i + 1] += leftDepths[i];
            depths[i + 1] += rightDepths[i];
        }

        int cnt = 0;
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j + i + 2 <= distance; j++) {
                cnt += leftDepths[i] * rightDepths[j];
            }
        }
        return new Pair(depths, cnt + leftCount + rightCount);
    }
}

class Pair {
    int[] depths;
    int count;

    public Pair(int[] depths, int count) {
        this.depths = depths;
        this.count = count;
    }
    */

    int cnt=0;
    List<Integer> dfs(TreeNode root, int distance, int level){
        if(root==null)return new ArrayList<>();
        if(root.left==null&&root.right==null){
            List<Integer> list=new ArrayList<>();
            list.add(level);
            return list;
        }
        List<Integer> left=dfs(root.left,distance,level+1);
        List<Integer> right=dfs(root.right,distance,level+1);
        for(int l:left){
            for(int r:right){
                if(l-level+r-level<=distance){
                    cnt++;
                }
            }
        }
        left.addAll(right);
        return left;
    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance,0);
        return cnt;
    }
}
