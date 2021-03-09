package 剑指offer;


public class 合成链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode pre = null;
        if (head == h1) {
            pre = h1;
            h1 = h1.next;
        }
        if (head == h2) {
            pre = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                pre.next = h1;
                pre = pre.next;
                h1 = h1.next;
            } else {
                pre.next = h2;
                pre = pre.next;
                h2 = h2.next;
            }
        }

        while (h1 != null) {
            pre.next = h1;
            pre = pre.next;
            h1 = h1.next;
        }
        while (h2 != null) {
            pre.next = h2;
            pre = pre.next;
            h2 = h2.next;
        }
        return head;
    }
}
