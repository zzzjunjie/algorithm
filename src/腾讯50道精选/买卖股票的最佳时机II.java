package 腾讯50道精选;

public class 买卖股票的最佳时机II {
    // 贪心算法
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = res + Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

    //动态规划
    public int maxProfit2(int[] prices) {
        // 使用dp[i][0] 表示第i天交易完后没有股票的收益,dp[i][1]第i天交易完成后手里还有股票
        // 状态转移方程dp[i][0]，如果第i天交易完成后手里没有股票，有两种情况：①前一天手里没有股票。②前一天手里有股票，但是今天卖出了
        // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        // 状态转移方程dp[i][1]，如果第i天交易完成后手里还有股票，有两种情况，①前一天手里没有股票，但是今天买了。②前一天手里有股票
        // dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 初始状态，在第一天的时候手里是没有股票的，如果购买了股票，手里的钱就应该是负的
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }

    //动态规划
    public int maxProfit3(int[] prices) {
        // 根据上面的分析，第i天的收益情况只会与前一天有关，所以我们可以只记录前一天的数值，不需要记录之前天的数值，做出如下优化
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int no = Math.max(dp0, dp1 + prices[i]);
            int yes = Math.max(dp0 - prices[i], dp1);
            dp0 = no;
            dp1 = yes;
        }
        return dp0;
    }
}
