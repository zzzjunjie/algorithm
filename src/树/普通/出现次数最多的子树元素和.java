package 树.普通;

import 树.节点.TreeNode;

import java.util.*;

public class 出现次数最多的子树元素和 {
    static Map<TreeNode,Integer> map = new HashMap<>();
    static  Map<Integer,Integer> res = new HashMap<>();
    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root== null){
            return new int[0];
        }
        help(root);
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value>max){
                list = new ArrayList<>();
                list.add(key);
                max = value;
                continue;
            }
            if (value == max){
                list.add(key);
            }
        }
        int[] intRes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intRes[i] = list.get(i);
        }
        return intRes;
    }

    public static void help(TreeNode root){
        if (root == null){
            return ;
        }
        int dfs = dfs(root);
        if (res.containsKey(dfs)) {
            int i = res.get(dfs)+ 1;
            res.put(dfs,i);
        }else{
            res.put(dfs,1);
        }
        help(root.left);
        help(root.right);
    }

    public static int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int res = left+right+root.val;
        map.put(root,res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> tmp = Arrays.asList(5,2,-3);
        Queue<Integer> list = new LinkedList<>(tmp);
        TreeNode root = new TreeNode(list.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll == null){
                continue;
            }
            Integer left = list.poll();
            Integer right = list.poll();
            if (left!=null){
                poll.left = new TreeNode(left);
            }
            if (right!=null){
                poll.right = new TreeNode(right);
            }

            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        int[] frequentTreeSum = findFrequentTreeSum(root);
        System.out.println(frequentTreeSum);
    }
}
