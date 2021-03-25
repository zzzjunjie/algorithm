package 腾讯50道精选;

public class 相交链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int alen = 0;
        int blen = 0;
        while (a!=null || b!=null) {
            if (a!=null){
                alen++;
                a = a.next;
            }
            if (b!=null){
                blen++;
                b = b.next;
            }
        }
        int index = Math.abs(alen - blen);
        if (alen > blen){
            for (int i = 0; i < index; i++) {
                headA = headA.next;
            }
        }else{
            for (int i = 0; i < index; i++) {
                headB = headB.next;
            }
        }
        while (headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
