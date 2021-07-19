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
	int max = 0;
	// K:当前节点的最大值
	Map<TreeNode,Integer> map = new HashMap<>();

	public int maxPathSum(TreeNode root) {
		dfs(root);
		return max;
	}

	private int dfs(TreeNode root){
		if (root==null){
			return 0;
		}
		if (map.containsKey(root)){
			return map.get(root);
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		int sum = root.val;
		if (left >0) {
			sum +=left;
		}
		if (right>0){
			sum +=right;
		}
		max = Math.max(max,sum);
		map.put(root,sum);
		return sum;
	}

}
