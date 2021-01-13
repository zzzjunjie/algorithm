package 树.普通;

import 树.节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 完全二叉树插入器 {
    private TreeNode root;
    private TreeNode inNode;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
       TreeNode tmp = new TreeNode(v);
       insert(root,tmp);
       return inNode.val;
    }

    private void insert(TreeNode root, TreeNode insertNode) {
        if (root==null){
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left !=null && poll.right == null){
                poll.right = insertNode;
                inNode = poll;
                return;
            }

            if (poll.left == null & poll.right == null){
                poll.left = insertNode;
                inNode = poll;
                return;
            }

            if (poll.left != null){
                queue.offer(poll.left);
            }
            queue.offer(poll.right);
        }
    }

    public TreeNode get_root() {
        return this.root;
    }
}
