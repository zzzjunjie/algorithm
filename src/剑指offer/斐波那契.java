package 剑指offer;

public class 斐波那契 {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        if (n == a) {
            return a;
        }
        if (n == b) {
            return b;
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
