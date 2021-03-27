package 腾讯50道精选;

import java.util.HashSet;
import java.util.Set;

public class 环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 使用set作为缓存，走过的点放入缓存中，如果缓存存在，那么就证明之前的点是走过的，会成环，否则就不为环
    public boolean hasCycle(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        while (head!=null){
            if (cache.contains(head)){
                return true;
            }
            cache.add(head);
            head = head.next;
        }
        return false;
    }

    // 使用快慢指针，如果会成环的话，快指针一定有一次会和慢指针重叠，如果不成环，那么快指针一定在慢指针的前面
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
