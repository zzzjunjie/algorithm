package 动态规划.简单;

public class 按摩师 {
    public int massage(int[] nums) {
        if (nums.length < 1) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int res = dp[0][1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            res = Math.max(dp[i][0], dp[i][1]);
        }
        return res;
    }
}
