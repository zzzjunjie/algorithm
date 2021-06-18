package 动态规划.普通;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/palindrome-partitioning/
public class 分割回文串 {
    int length;
    boolean[][] dp;
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        length = s.length();
        dp = new boolean[length][length];
        // 设f(i,j)为i~j之间是回文子串，那么f(i,j)是否为回文子串取决于f(i+1,j-1)&&s[i]==s[j]
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], true);
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < length; j++) {
            if (dp[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        分割回文串 test = new 分割回文串();
        List<List<String>> aab = test.partition("aab");
        System.out.println(aab);
    }
}
