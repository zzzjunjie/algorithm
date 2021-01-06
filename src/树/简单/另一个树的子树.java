package 树.简单;

import 树.节点.TreeNode;

public class 另一个树的子树 {


    // 这个就是LeetCode100 题的那个函数
    public boolean isSameTree(TreeNode s, TreeNode t){
        // 同时为空 说明树一起到底，两树相同
        if (s==null && t == null){
            return true;
        }
        // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
        if (s == null || t == null){
            return false;
        }
        // 如果判断到了这一步，说明两个都不为空
        // 先序遍历 自己--左 -- 右
        if (s.val != t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 我s都遍历完了。你居然还没匹配上。那就返回false
        if (s==null){
            return false;
        }
        // 短路运算符，有一个为真，返回真
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }


//    List<Character> list1=new ArrayList<>();
//    List<Character> list2=new ArrayList<>();
//    int[]next;
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(t==null) return true;
//        dfs(s,list1);
//        dfs(t,list2);
//        build(list2);
//        for(int i=0,j=0;i<list1.size();i++){
//            while(j>0&&!list1.get(i).equals(list2.get(j)))
//                j=next[j];
//            if(list1.get(i).equals(list2.get(j))){
//                j++;
//            }
//            if(j==list2.size())
//                return true;
//        }
//        return false;
//    }
//    private void dfs(TreeNode root, List<Character> sb){
//        if(root==null){
//            sb.add(' ');
//            return;
//        }
//        sb.add((char)(root.val+'0'));
//        dfs(root.left,sb);
//        dfs(root.right,sb);
//        return;
//    }
//    private void build(List<Character> p){
//        next=new int[p.size()+1];
//        next[0]=0;
//        next[1]=0;
//        int index=2;
//        for(int i=1,j=0;i<p.size();i++){
//            while(j>0&&!p.get(i).equals(p.get(j)))
//                j=next[j];
//            if(p.get(i).equals(p.get(j)))
//                j++;
//            next[index++]=j;
//        }
//    }


//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        return dfs(s, t);
//    }
//
//    public boolean dfs(TreeNode s, TreeNode t) {
//        if (s == null) {
//            return false;
//        }
//        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
//    }
//
//    public boolean check(TreeNode s, TreeNode t) {
//        if (s == null && t == null) {
//            return true;
//        }
//        if (s == null || t == null || s.val != t.val) {
//            return false;
//        }
//        return check(s.left, t.left) && check(s.right, t.right);
//    }
}
