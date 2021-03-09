package 剑指offer;

public class 青蛙跳台阶Ⅱ {
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % 1000000007;
            if (i == n) {
                res = c;
            }
            a = b;
            b = c;
        }
        return res;
    }
}
