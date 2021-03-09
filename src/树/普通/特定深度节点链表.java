package 树.普通;

import 树.节点.ListNode;
import 树.节点.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 特定深度节点链表 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode item = null;
            ListNode cur = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (item == null) {
                    item = new ListNode(poll.val);
                    cur = item;
                } else {
                    cur.next = new ListNode(poll.val);
                    cur = cur.next;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(item);
        }
        ListNode[] result = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;

    }
}
