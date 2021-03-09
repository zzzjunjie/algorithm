package 剑指offer;

public class 链表中倒数第k个节点 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode low = head;
        ListNode hight = head;
        for (int i = 0; i < k; i++) {
            hight = hight.next;
        }
        while (hight != null) {
            hight = head.next;
            low = low.next;
        }
        return low;
    }

}
