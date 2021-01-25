package 树.普通;

import 树.节点.TreeNode;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class 奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root==null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            int val = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null) {
                    queue.offer(poll.left);
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                }
                if (flag){
                    if (poll.val%2!=1) {
                        return false;
                    }
                }else{
                    if (poll.val%2!=0){
                        return false;
                    }
                }
                if (i!=0) {
                    if (flag){
                        if (!(val<poll.val ) ) {
                            return false;
                        }
                    }else{
                        if (!(val > poll.val)){
                            return false;
                        }
                    }
                }
                val = poll.val;
            }
            flag = !flag;
        }
        return true;
    }
}
