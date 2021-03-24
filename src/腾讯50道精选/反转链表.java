package 腾讯50道精选;

public class 反转链表 {
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

    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode l = head;
        ListNode m = l.next;
        ListNode r = m.next;
        l.next = null;
        while (r!=null){
            m.next = l;
            l = m;
            m = r;
            r = r.next;
        }
        m.next = l;
        return m;
    }
}
