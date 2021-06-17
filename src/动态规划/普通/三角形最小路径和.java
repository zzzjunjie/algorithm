package 动态规划.普通;

import java.util.List;

public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        // 设dp[i][j]为三角形顶部到i,j点上的最小值
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[size - 1][0];
        for (int i : dp[size - 1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}
