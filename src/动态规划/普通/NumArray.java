package 动态规划.普通;

// 303. 区域和检索 - 数组不可变
// https://leetcode-cn.com/problems/range-sum-query-immutable/
public class NumArray {
	int dp[];
	public NumArray(int[] nums) {
		int length = nums.length;
		dp = new int[length + 1];

		for (int i = 0; i < length; i++) {
			dp[i + 1] = dp[i] + nums[i];
		}
	}

	public int sumRange(int left, int right) {

		return dp[right+1] - dp[left];
	}
}
