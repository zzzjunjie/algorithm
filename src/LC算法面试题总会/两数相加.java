package LC算法面试题总会;

import 树.节点.ListNode;

public class 两数相加 {
    public static void main(String[] args) {

    }

    // 简洁解法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }


    /** 自己的解法
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode p = l1;
     ListNode q = l2;
     int flage = 0;
     ListNode res = null;
     ListNode index = res;
     while (p != null || q != null) {
     int val = 0 ;
     if (p !=null && q!=null){
     int sum = p.val + q.val + flage;
     flage = sum / 10;
     val = sum % 10;
     p = p.next;
     q = q.next;
     }else if (p==null){
     int sum = q.val + flage;
     flage = sum / 10;
     val = sum % 10;
     q = q.next;
     }else if (q == null){
     int sum = p.val+flage;
     flage = sum / 10;
     val = sum % 10;
     p = p.next;
     }

     if (res == null){
     res = new ListNode(val);
     index = res;
     }else{
     index.next = new ListNode(val);
     index = index.next;
     }
     }
     if (flage !=0){
     index.next = new ListNode(flage);
     }
     return res;
     }*/
}
