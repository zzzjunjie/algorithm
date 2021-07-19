package 树.普通;


import java.util.Arrays;


public class 最高频元素的频数 {
	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int max=0,tempSum=0;
		for (int i=0,j = 0; j < nums.length; j++) {
			while(nums[j]*(j-i)-tempSum>k){
				tempSum-=nums[i++];
			}
			tempSum+=nums[j];
			max=Math.max(max, j-i+1);
		}
		return max;
	}
}
