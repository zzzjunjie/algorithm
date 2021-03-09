package 剑指offer;

//第二种方式，只需要花费 O(n)的时间复杂度
//
//        首先我们需要准备两个指针，第一个指针指向第一个的头部，另一个指向第二个链表的头部，然后我们同时移动这两个指针，当有一个指针到头的时候，另一个指针还没有到头，我们记录到这个差值N
//
//        然后在再次这样指向，但是首先需要保证那个长的链表先执行 N步，然后这两个节点再一次走，直到两个节点相交的时候，就得到了第一个公共节点。
public class 两个链表的公共结点 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        l7.next = l8;
        l8.next = l5;


        System.out.println(getIntersectionNode(l1, l7));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        // 如果a比较长
        if (null != a) {
            int k = 0;
            while (a != null) {
                a = a.next;
                k++;
            }
            a = headA;
            b = headB;
            // 先让a跳K个坑
            for (int i = k; i > 0; i--) {
                a = a.next;
            }

            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;
        } else {
            int k = 0;
            while (b != null) {
                b = b.next;
                k++;
            }
            a = headA;
            b = headB;
            // 先让a跳K个坑
            for (int i = k; i > 0; i--) {
                b = b.next;
            }

            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return b;
        }
//        ----------------------------------------------------
//        if (headA == headB){
//            return headA;
//        }
//
//        if (headA==null || headB==null){
//            return null;
//        }
//
//        ListNode a = headA;
//        ListNode b = headB;
//        while (a!=null && b!=null){
//            a = a.next;
//            b = b.next;
//        }
//        int poor = 0;
//        ListNode longHead = null;
//        ListNode shortHead = null;
//        while (a != null){
//            longHead = headA;
//            shortHead = headB;
//            a = a.next;
//            poor++;
//        }
//        while (b != null){
//            longHead = headB;
//            shortHead = headA;
//            b = b.next;
//            poor++;
//        }
//        while (longHead !=null && poor >0){
//            longHead = longHead.next;
//            poor--;
//        }
//
//        while (longHead !=null && shortHead !=null){
//            if (longHead == shortHead){
//                return longHead;
//            }
//            longHead = longHead.next;
//            shortHead = shortHead.next;
//        }
//        return null;
    }
}
