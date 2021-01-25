package 树.普通;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class 填充每个节点的下一个右侧节点指针_II {
    public Node connect(Node root)  {
        if (root==null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i==0){
                    pre = poll;
                }else{
                    pre.next = poll;
                    pre = pre.next;
                }
               if (poll.left!=null){
                   queue.offer(poll.left);
               }
               if (poll.right!=null){
                   queue.offer(poll.right);
               }
            }
        }
        return root;
    }
}
