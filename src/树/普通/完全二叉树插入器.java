package 树.普通;

/**
 * https://leetcode-cn.com/problems/complete-binary-tree-inserter/submissions/
 */
public class 完全二叉树插入器 {
    /* 自己的解法
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
    */

/* 双端队列
    TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
    */
}
