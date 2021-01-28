package 树.困难;

import 树.节点.TreeNode;

public class 从先序遍历还原二叉树 {
    int pos, last;
    public TreeNode recoverFromPreorder(String S) {
        return dfs(S.toCharArray(), 0);
    }

    public TreeNode dfs(char[] s, int cur){
        int num = 0;
        while(pos < s.length && s[pos] != '-'){
            num = num * 10 - '0' + s[pos++];
        }
        int count = 0;
        while(pos < s.length && s[pos] == '-'){
            ++pos;
            ++count;
        }
        last = count;
        TreeNode node = new TreeNode(num);
        if(count == cur + 1) node.left = dfs(s, count);
        if(last == cur + 1) node.right = dfs(s, last);
        return node;
    }
}
