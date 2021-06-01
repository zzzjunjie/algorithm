package 剑指offer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class 恢复空格 {

	public int respace(String[] dictionary, String sentence) {
		Set<String> set = new HashSet<>(Arrays.asList(dictionary));
		int len = sentence.length();
		// dp数组代表从[0,i)中未识别的字符
		int[] dp = new int[len + 1];
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			// 假设当前字符未能识别
			dp[i] = dp[i - 1] + 1;
			for (int j = 0; j < i; j++) {
				String substring = sentence.substring(j, i);
				if (set.contains(substring)){
					dp[i] = Math.min(dp[j],dp[i]);
				}
			}
		}
		return dp[len];
	}

}
