package 查找算法.KMP;

public class KMP {

    public static void main(String[] args) {
        String source = "ABCDEFCDE";
        String target = "CDE";
        kmp(source, target);
    }

    public static void kmp(String source, String target) {
        int slen = source.length();
        int tlen = target.length();
        int[] pi = computePrefixFunction(target);
        int q = 0;
        for (int i = 0; i < slen; i++) {

            while (q > 0 && source.charAt(i) != target.charAt(q)) {
                q = pi[q - 1];
            }

            if (source.charAt(i) == target.charAt(q)) {
                q++;
            }

            if (q == tlen) {
                System.out.println(i - tlen + 1);
                System.out.println(source.substring(i - tlen + 1, i + 1));
                q = 0;
            }
        }
    }

    private static int[] computePrefixFunction(String target) {
        int length = target.length();
        int[] pi = new int[length];
        int q = 0;
        for (int i = 1; i < length; i++) {
            while (q > 0 && target.charAt(q) != target.charAt(q)) {
                q = pi[q - 1];
            }

            if (target.charAt(q) == target.charAt(i)) {
                q++;
            }
            pi[i] = q;
        }
        return pi;
    }

//    public static void main(String[] args) {
//        final String haystack = "ABCDEFGHEFG";
//        final String needle = "EFG";
//        KMPmatcher2(haystack, needle);
//    }
//
//    public static void KMPmatcher(final String haystack, final String needle) {
//        final int m = haystack.length();
//        final int n = needle.length();
//        // 先将查找的表生成
//        final int[] pi = computePrefixFunction(needle);
//        int q = 0;
//        for (int i = 0; i < m; i++) {
//            while (q > 0 && haystack.charAt(i) != needle.charAt(q)) {
//                char c1 = haystack.charAt(i);
//                char c2 = needle.charAt(q);
//                q = pi[q - 1];
//            }
//            if (haystack.charAt(i) == needle.charAt(q)) {
//                q++;
//            }
//
//            if (q == n) {
//                System.out.println(haystack.substring(i - n + 1, i + 1));
//                System.out.println("Pattern starts: " + (i + 1 - n));
//                q = pi[q - 1];
//            }
//        }
//    }
//
//    // 计算前缀和后缀的公共数目
//    private static int[] computePrefixFunction(final String P) {
//        final int n = P.length();
//        final int[] pi = new int[n];
//        pi[0] = 0;
//        int q = 0;
//        for (int i = 1; i < n; i++) {
//            while (q > 0 && P.charAt(q) != P.charAt(i)) {
//                q = pi[q - 1];
//            }
//
//            if (P.charAt(q) == P.charAt(i)) {
//                q++;
//            }
//
//            pi[i] = q;
//        }
//        return pi;
//    }
//
//    public static void KMPmatcher2(final String haystack, final String needle) {
//        int n = haystack.length();
//        int m = needle.length();
//        int[] pi = computePrefixFunction2(needle);
//        int q = 0;
//        for (int i = 1; i < n; i++) {
//            while (q > 0 && haystack.charAt(i) != needle.charAt(q)){
//                q = pi[q - 1];
//            }
//            if (haystack.charAt(i) == needle.charAt(q)){
//                q ++;
//            }
//            if (q == m){
//                System.out.println(i - m + 1);
//            }
//        }
//    }
//
//    // 计算前缀和后缀的公共数目
//    private static int[] computePrefixFunction2(final String P) {
//        int len = P.length();
//        int[] pi = new int[len];
//        int q = 0;
//        for (int i = 1; i < pi.length; i++) {
//
//            while (q > 0 && P.charAt(i) != P.charAt(q)) {
//                q = pi[q - 1];
//            }
//            if (P.charAt(q) == P.charAt(i)) {
//                q++;
//            }
//            pi[i] = q;
//        }
//        return pi;
//    }
}
