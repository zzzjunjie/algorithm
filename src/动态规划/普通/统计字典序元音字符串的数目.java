package 动态规划.普通;

public class 统计字典序元音字符串的数目 {

    //动态规划解法
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        // 初始化数组，长度为1开头的只有一个
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        // 从长度为2的开始
        for (int i = 2; i <= n; i++) {
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][0] = dp[i - 1][0];
        }
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }


    //数学问题解法
//    public int countVowelStrings(int n) {
//        return ((n+1)*(n+2)*(n+3)*(n+4))/24;
//    }
}
