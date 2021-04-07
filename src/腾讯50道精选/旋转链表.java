package 腾讯50道精选;


public class 旋转链表 {

	public static class ListNode {

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

	public static ListNode rotateRight(ListNode head, int k) {
		if (head==null || head.next == null || k == 0){
			return head;
		}
		// 获取链表的长度
		ListNode index = head;
		int len =0;
		while (index!=null){
			len++;
			index = index.next;
		}
		if (k %len == 0){
			return head;
		}
		// 链表长度-需要移动的长度
		int n = k > len ? len - k % len - 1 : len - k - 1;
		// 链表一分为2，将后面的作为头，前面的作为尾部
		ListNode p = head;
		ListNode q = null;
		for (int i = 0; i < n; i++) {
			p = p.next;
		}
		q = p.next;
		p.next = null;
		ListNode m = q;
		while (q.next != null){
			q = q.next;
		}
		q.next = head;
		return m;
	}


	public ListNode rotateRight2(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null) {
			return head;
		}
		int n = 1;
		ListNode iter = head;
		while (iter.next != null) {
			iter = iter.next;
			n++;
		}
		int add = n - k % n;
		if (add == n) {
			return head;
		}
		iter.next = head;
		while (add-- > 0) {
			iter = iter.next;
		}
		ListNode ret = iter.next;
		iter.next = null;
		return ret;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode listNode = rotateRight(l1, 1);
		System.out.println(listNode);
	}
}
