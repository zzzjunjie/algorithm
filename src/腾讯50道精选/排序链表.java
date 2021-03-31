package 腾讯50道精选;


import java.util.ArrayList;
import java.util.List;


public class 排序链表 {

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

	// 将所有元素放入list，在list中排序完成后进行链表构建
	public ListNode sortList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		list.sort(Integer::compare);
		ListNode res = new ListNode(0);
		ListNode p = res;
		for (Integer item : list) {
			p.next = new ListNode(item);
			p = p.next;
		}
		return res.next;
	}

	// 使用归并排序自顶向下
	public static ListNode sortList2(ListNode head) {
		return sortList(head, null);
	}

	public static ListNode sortList(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}
		if (head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}
		ListNode mid = slow;
		ListNode list1 = sortList(head, mid);
		ListNode list2 = sortList(mid, tail);
		return merge(list1, list2);
	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead;
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		} else if (temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}
	// 使用归并排序自底向上

	// 使用快速排序解决
	public static ListNode sortList3(ListNode head){
		quickSort(head,null);
		return head;
	}

	private static void quickSort(ListNode head, ListNode tail) {
		if (head!=tail){
			ListNode partion = partion(head, tail);
			quickSort(head,partion);
			quickSort(partion.next,tail);
		}
	}

	// 已最右边的值作为基准数
	public static ListNode partion(ListNode head,ListNode tail){
		// 将节点的第一个作为基准数

		ListNode p = head;
		ListNode q = p.next;
		while (q!=tail){
			if (q.val < head.val){
				p = p.next;
				if (p!=q){
					int val = p.val;
					p.val = q.val;
					q.val = val;
				}
			}
			q = q.next;
		}
		if (p!= head){
			int val = p.val;
			p.val = head.val;
			head.val = val;
		}
		return p;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		ListNode p = head;
		p.next = new ListNode(1);
		p = p.next;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(9);
		p = p.next;
		p.next = new ListNode(7);
		p = p.next;
		ListNode listNode = sortList3(head);
		System.out.println(listNode);
	}
}
