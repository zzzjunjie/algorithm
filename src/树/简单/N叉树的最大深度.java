package 树.简单;

import org.omg.CORBA.MARSHAL;
import 树.节点.Node;

import java.util.LinkedList;
import java.util.Queue;

public class N叉树的最大深度 {

    public int maxDepth(Node root) {
        if (root==null) {
            return 0;
        }
        int level = 0;
        for (Node child : root.children) {
           level = Math.max(level,maxDepth(child));
        }
        return level + 1;
    }

    public int maxDepth2(Node root) {  //层序遍历解法
        if(root == null)
            return 0;
        if(root.children.size() == 0)
            return 1;
        int depth = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            depth++;
            while(count > 0){
                Node node = queue.poll();
                if(node.children.size() != 0)
                    queue.addAll(node.children);
                count--;
            }
        }
        return depth;
    }
}
