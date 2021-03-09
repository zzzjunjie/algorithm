package 动态规划.简单;

//https://leetcode-cn.com/problems/maximum-subarray/
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(num + pre, num);
            res = Math.max(pre, res);
        }
        return res;
    }
}
