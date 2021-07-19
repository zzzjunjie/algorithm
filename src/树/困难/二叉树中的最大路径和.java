package 树.困难;


import java.util.HashMap;
import java.util.Map;


class TreeNode {

	int val;

	TreeNode left;

	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}


public class 二叉树中的最大路径和 {

	int max = Integer.MIN_VALUE;

	// K:当前节点的最大值
	Map<TreeNode, Integer> map = new HashMap<>();

	public int maxPathSum(TreeNode root) {
		max = root.val;
		dfs(root);
		return max;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (map.containsKey(root)) {
			return map.get(root);
		}
		int left = Math.max(0, dfs(root.left));
		int right = Math.max(0, dfs(root.right));
		max = Math.max(max, left + right + root.val);
		int curMax = Math.max(left, right) + root.val;
		map.put(root, curMax);
		return curMax;
	}

}
