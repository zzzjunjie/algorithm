package 树;

import 树.节点.TreeNode;

public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums.length>0?dfs(nums,0,nums.length):null;
    }

    public TreeNode dfs(int[] nums,int l,int r){
        if (l>r){
            return null;
        }
        int mid = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums,l,mid-1);
        node.right = dfs(nums,mid+1,r);
        return node;
    }
}
