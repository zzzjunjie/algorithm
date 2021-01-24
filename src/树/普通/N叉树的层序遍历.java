package 树.普通;

import 树.节点.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root==null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll!=null){
                    item.add(poll.val);
                    if (poll.children!=null){
                        for (Node child : poll.children) {
                            queue.offer(child);
                        }
                    }
                }
            }
            res.add(item);
        }
        return res;
    }
}
