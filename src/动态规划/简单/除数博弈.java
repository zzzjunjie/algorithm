package 动态规划.简单;

public class 除数博弈 {
    public boolean divisorGame(int N) {
        boolean[] f = new boolean[N + 2];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[N];
    }
}
