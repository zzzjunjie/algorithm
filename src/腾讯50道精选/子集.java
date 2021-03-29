package 腾讯50道精选;


import java.util.ArrayList;
import java.util.List;


public class 子集 {
	List<Integer> t = new ArrayList<>();
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		dfs(0,nums);
		return ans;
	}

	public void dfs(int cur, int[] nums) {
		if (cur ==nums.length){
			ans.add(new ArrayList<>(t));
			return;
		}

		t.add(nums[cur]);
		dfs(cur+1,nums);
		t.remove(t.size()-1);
		dfs(cur+1,nums);
	}

	public List<List<Integer>> subsets2(int[] nums) {
		int n = nums.length;
		for (int mask = 0; mask < (1 << n); ++mask) {
			t.clear();
			for (int i = 0; i < n; ++i) {
				if ((mask & (1 << i)) != 0) {
					t.add(nums[i]);
				}
			}
			ans.add(new ArrayList<Integer>(t));
		}
		return ans;
	}
}
