package 树.简单;

import 树.节点.TreeNode;

import java.util.Arrays;

public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

//    public TreeNode sortedArrayToBST(int[] nums) {
//        if(nums.length==0) return null;
//        TreeNode n = new TreeNode(nums[nums.length/2]);
//        n.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
//        n.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
//        return n;
//    }
//
//    作者：zackqf
//    链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci/solution/javadi-gui-5xing-dai-ma-by-zackqf/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
