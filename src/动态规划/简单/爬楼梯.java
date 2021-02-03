package 动态规划.简单;

public class 爬楼梯 {
    public int climbStairs(int n) {
        // 定义状态数组:dp[i] = dp[i-2] + dp[i-1]
        // dp[i]代表第i阶台阶有多少种上发
        int[] dp = new int[n+2];//这里定义n+2是为了避免n太小导致数组越界的问题
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}
