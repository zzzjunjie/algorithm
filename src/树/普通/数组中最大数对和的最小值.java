package 树.普通;


import java.util.Arrays;


public class 数组中最大数对和的最小值 {

	public int minPairSum(int[] nums) {
		int res = Integer.MIN_VALUE;
		Arrays.sort(nums);
		int p = 0;
		int q = nums.length - 1;
		while (p <=q){
			res = Math.max(res,nums[p]+nums[q]);
			p++;
			q--;
		}
		return res;
	}

}
