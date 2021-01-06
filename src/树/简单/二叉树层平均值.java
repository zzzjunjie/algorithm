package 树.简单;

import sun.security.util.math.ImmutableIntegerModuloP;
import 树.节点.TreeNode;

import javax.activation.MailcapCommandMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RecursiveTask;

public class 二叉树层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0 ;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                }
                sum = sum + poll.val;
                System.out.println(sum);
            }
            res.add(sum/size);
        }
        return res;
    }


}
