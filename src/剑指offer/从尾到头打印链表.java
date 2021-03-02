package 剑指offer;

import 树.节点.ListNode;

public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
       if (head == null){
           return new int[0];
       }

       ListNode index = head;
       int len = 0;
       while (index!=null){
           index = index.next;
           len++;
       }

       int[] res = new int[len];
       index = head;
        for (int i = 0; i < len; i++) {
            res[len - i -1] = index.val;
            index = index.next;
        }
        return res;
    }
}
