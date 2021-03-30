package 腾讯50道精选;

import java.util.Arrays;
// https://leetcode-cn.com/problems/product-of-array-except-self/submissions/
public class 除自身以外数组的乘积 {


    public static void main(String[] args) {
        int[] res = {1,2,3,4};
        int[] ints = productExceptSelf(res);
        System.out.println(Arrays.toString(ints));
    }
    // 思路：计算出每个位置除i的前缀乘积、后缀乘积，那么res[i] = pre[i] * suffix[i]
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] pre = new int[len];
        int[] suffix = new int[len];
        int[] res = new int[len];

        pre[0] = 1;
        suffix[len-1] = 1;

        // 计算所有除了i的前缀和
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }

        for (int i = len-2; i >=0 ; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = pre[i] * suffix[i];
        }

        return res;
    }
}
