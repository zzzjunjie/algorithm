package 动态规划.普通;


import java.util.Arrays;


// https://leetcode-cn.com/problems/reducing-dishes/
public class 做菜顺序 {

	public int maxSatisfaction(int[] satisfaction) {
		Arrays.sort(satisfaction);
		int sum = 0;
		int ans = 0;
		for (int i = satisfaction.length - 1; i >= 0; i--) {
			int tmp = satisfaction[i];
			if (tmp + sum >0){
				sum +=tmp;
				ans +=sum;
				continue;
			}
			break;
		}
		return ans;
	}

}
