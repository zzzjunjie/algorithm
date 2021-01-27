package 查找算法.KMP;

public class KMP {

    public static void main(String[] args) {
        final String haystack = "BBC ABCDAB ABCDABCDABDE";
        final String needle = "ABCDABD";
        KMPmatcher(haystack, needle);
    }

    public static void KMPmatcher(final String haystack, final String needle) {
        final int m = haystack.length();
        final int n = needle.length();
        final int[] pi = computePrefixFunction(needle);
        int q = 0;
        for (int i = 0; i < m; i++) {
            while (q > 0 && haystack.charAt(i) != needle.charAt(q)) {
                char c1 = haystack.charAt(i);
                char c2 = needle.charAt(q);
                q = pi[q - 1];
            }
            if (haystack.charAt(i) == needle.charAt(q)) {
                q++;
            }

            if (q == n) {
                System.out.println("Pattern starts: " + (i + 1 - n));
                q = pi[q - 1];
            }
        }
    }

    private static int[] computePrefixFunction(final String P) {
        final int n = P.length();
        final int[] pi = new int[n];
        pi[0] = 0;
        int q = 0;
        for (int i = 1; i < n; i++) {
            while (q > 0 && P.charAt(q) != P.charAt(i)) {
                q = pi[q - 1];
            }

            if (P.charAt(q) == P.charAt(i)) {
                q++;
            }

            pi[i] = q;
        }
        return pi;
    }
}
