package 动态规划.普通;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder stringBuffer = new StringBuilder();
        dfs(n,n,stringBuffer);
        return res;
    }

    private void dfs(int left, int right, StringBuilder str) {
        if (left == 0 && right == 0) {
            this.res.add(str.toString());
            return;
        }

        if (left > right){
            return;
        }

        if (left > 0) {
            str.append("(");
            dfs(left - 1, right, str);
            str.deleteCharAt(str.length() - 1);
        }

        if (right > 0) {
            str.append(")");
            dfs(left, right - 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
