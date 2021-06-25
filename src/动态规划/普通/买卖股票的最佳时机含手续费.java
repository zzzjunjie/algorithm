package 动态规划.普通;

public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) return 0;
        // 两个状态，不持有股票和持有
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][1] = -prices[0];
        // 状态转移
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
