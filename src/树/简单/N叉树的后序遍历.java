package 树.简单;

import 树.节点.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N叉树的后序遍历 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
       dfs(root);
        if (root!=null){
            res.add(root.val);
        }
       return res;
    }

    public void dfs(Node root){
        if (root==null){
            return;
        }

        for (Node child : root.children) {
            dfs(child);
            res.add(child.val);
        }
    }


    public List<Integer> postorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}
