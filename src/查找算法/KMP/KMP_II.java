package 查找算法.KMP;

import java.nio.channels.Pipe;

public class KMP_II {
    public static void main(String[] args) {
        String s1 = "ABCDEFG";
        String s2 = "DE";
        search(s1, s2);
    }

    public static void search(String source, String targe) {
        int m = source.length();
        int n = targe.length();
        int[] p = prepare(targe);
        int q = 0;
        for (int i = 0; i < m; i++) {
            while (q > 0 && source.charAt(i) != targe.charAt(q)) {
                q = p[q - 1];
            }

            if (source.charAt(i) == targe.charAt(q)) {
                q++;
            }

            if (q == n) {
                System.out.println(i - n + 1);
                q = p[q - 1];
            }
        }
    }

    private static int[] prepare(String targe) {
        int len = targe.length();
        if (len <= 0) {
            return new int[0];
        }
        int[] p = new int[len];
        p[0] = 0;
        int q = 0;
        for (int i = 1; i < len; i++) {
            while (q > 0 && targe.charAt(q) != targe.charAt(i)) {
                q = p[q - 1];
            }

            if (targe.charAt(q) == targe.charAt(i)) {
                q++;
            }

            p[i] = q;
        }
        return p;
    }
}
