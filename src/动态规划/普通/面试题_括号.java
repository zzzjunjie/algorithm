package 动态规划.普通;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/bracket-lcci/
 */
public class 面试题_括号 {
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        int leftBracket = n, rightBracket = n;
        this.res = new ArrayList<>();
        dfs(leftBracket, rightBracket, new StringBuilder());
        return res;
    }

    private void dfs(int leftBracket, int rightBracket, StringBuilder sb) {
        if (leftBracket == 0 && rightBracket == 0) {
            res.add(sb.toString());
            return;
        }

        if (leftBracket > rightBracket) {
            return;
        }

        if (leftBracket > 0) {
            sb.append("(");
            dfs(leftBracket - 1, rightBracket, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracket > 0) {
            sb.append(")");
            dfs(leftBracket, rightBracket - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
