package 树.普通;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化和反序列化二叉搜索树 {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder("");
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur==null){
                ans.append("N ");
                continue;
            }else{
                ans.append(cur.val).append(" ");
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return ans.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] ss = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        int val = Integer.parseInt(ss[0]);
        TreeNode root = new TreeNode(val);
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(ss[i].equals("N")){
                i++;
            }else{
                TreeNode left = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                node.left = left;
                queue.add(left);
            }
            if(ss[i].equals("N")){
                i++;
            }else{
                TreeNode right = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
