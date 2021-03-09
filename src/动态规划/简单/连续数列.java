package 动态规划.简单;

// [-2,1,-3,4,-1,2,1,-5,4] 输出:6
public class 连续数列 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }
        return res;
    }
}
