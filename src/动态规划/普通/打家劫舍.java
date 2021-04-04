package 动态规划.普通;

public class 打家劫舍 {
    //  dp[i][0]:代表第i家不偷能赚到的最大大钱 dp[i][1]:代表第i家偷不触发警报能拿到的最大钱
    // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0])
    // dp[i][1] = dp[i][0] + nums[i];
    // dp[1][0] = 0,dp[1][1] = nums[0]
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        int[][] dp = new int[len + 1][2];
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 2; i < len + 1; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[len][0], dp[len][1]);
    }

    public static int rob2(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int no = Math.max(dp0,dp1);
            int yes = dp0 + nums[i];
            dp0 = no;
            dp1 = yes;
        }
        return Math.max(dp0,dp1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(rob(arr));
    }
}
