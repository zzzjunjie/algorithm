package 树.普通;


import 树.节点.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class 填充每个节点的下一个右侧节点指针 {
//    public Node connect(Node root) {
//        if (root==null){
//            return root;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            boolean flag = false;
//            Node pre = null;
//            for (int i = 0; i < size; i++) {
//                Node poll = queue.poll();
//                if (pre!=null){
//                    pre.children = poll;
//                }
//                pre = poll;
//                if (poll.left!=null){
//                    queue.offer(poll.left);
//                }
//                if (poll.right!=null){
//                    queue.offer(poll.right);
//                }
//            }
//        }
//        return root;
//    }
}
