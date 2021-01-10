package 树.普通;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */

public class 不同的二叉搜索树 {
    /**
    // 年轻不知动态规划好 老了学不懂了 - -
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
     */

    /** 备忘录方法解法
    Map<Integer, Integer> memory = new HashMap<>();
    public int numTrees(int n) {
        return helper(1, n);
    }
    public int helper(int begin, int end) {
        //因为二叉搜索树的种类只与节点个数有关，那么建立备忘录，防止重复计算
        if (memory.containsKey(end - begin))
            return memory.get(end - begin);
        //空二叉树也是一棵搜索二叉树
        if (begin > end)
            return 1;
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            //以i为根节点时左，右子树的个数
            int leftSize = helper(begin, i - 1);
            int rightSize = helper(i + 1, end);
            sum += leftSize * rightSize;
        }
        memory.put(end - begin, sum);
        return sum;
    }
     */
    Map<Integer,Integer> memory = new HashMap<>();
    public int numTrees(int n) {
        return dp(1,n);
    }

    private int dp(int start,int end) {
        if (start>end){
            return 1;
        }
        if (memory.containsKey(end-start)){
            return memory.get(end-start);
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int leftSize = dp(start, i - 1);
            int rightSize = dp(i + 1, end);
            sum = sum + (leftSize * rightSize);
        }
        memory.put(end-start,sum);
        return sum;
    }


}
