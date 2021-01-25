package 树.普通;

import com.sun.xml.internal.bind.v2.model.core.ID;
import 树.节点.TreeNode;

public class 路径总和_III {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }

        dfs(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res;
    }

    public void dfs(TreeNode root,int sum){
        if (root==null){
            return ;
        }

        sum = sum - root.val;
        if (sum==0){
            res ++;
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
