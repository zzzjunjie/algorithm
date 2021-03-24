package 腾讯50道精选;

public class 买卖股票的最佳时机II {
    // 贪心算法
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = res + Math.max(0,prices[i]-prices[i-1]);
        }
        return res;
    }
}
