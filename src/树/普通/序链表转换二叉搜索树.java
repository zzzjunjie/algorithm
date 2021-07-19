package 树.普通;


public class 序链表转换二叉搜索树 {

	public class ListNode {

		int val;

		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}


	public class TreeNode {

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

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}

		ListNode pre = head;
		ListNode p = head.next;
		ListNode q = p.next;

		while (q != null && q.next != null) {
			pre = pre.next;
			p = pre.next;
			q = q.next.next;
		}
		pre.next = null;
		TreeNode root = new TreeNode(p.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(p.next);
		return root;
	}

}
