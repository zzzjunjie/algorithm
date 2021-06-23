package 动态规划.普通;

import java.util.Arrays;

public class 鸡蛋掉落_枚鸡蛋 {
    public int twoEggDrop(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] = Math.min(f[i], Math.max(j, f[i - j] + 1));
            }
        }
        return f[n];
    }


}
