package 腾讯50道精选;

public class 删除链表中的节点 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
