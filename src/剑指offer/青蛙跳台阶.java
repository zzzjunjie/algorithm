package 剑指offer;

public class 青蛙跳台阶 {
    public static int func(int n) {
        if (n == 1) {
            return 1;
        }
        int ret = 0;
        int a = 1;
        for (int i = 2; i < n + 1; i++) {
            ret = 2 * a;
            a = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(func(7));
    }
}
