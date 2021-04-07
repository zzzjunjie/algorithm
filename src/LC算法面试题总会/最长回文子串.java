package LC算法面试题总会;

public class 最长回文子串 {
    // 最长回文子串
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len <= 0) {
            return "";
        }
        boolean[][] lps = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 3) {
                    lps[j][i] = chars[j] == chars[i];
                } else {
                    lps[j][i] = lps[j + 1][i - 1] && (chars[i] == chars[j]);
                }

                if (lps[j][i] && (i - j + 1) > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    //最长回文子序列
    public int getLPS(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 第一维参数表示起始位置的坐标，第二维参数表示长度，使用 0 表示长度 1
        int[][] lps = new int[length][length];
        for (int i = 0; i < length; i++) {
            lps[i][i] = 1; // 单个字符的最长回文子序列长度为1，特殊对待一下
        }
        // (i + 1) 表示当前循环的子字符串长度
        for (int i = 1; i < length; i++) {
            // j 表示当前循环的字符串起始坐标
            for (int j = 0; i + j < length; j++) {
                // 即当前循环的子字符串坐标为 [j, i + j]
                // 所以第一个字符是 chars[j]，最后一个字符就是 chars[i + j]
                if (chars[j] == chars[i + j]) {
                    lps[j][i + j] = lps[j + 1][i + j - 1] + 2;
                } else {
                    lps[j][i + j] = Math.max(lps[j][i + j - 1], lps[j + 1][i + j]);
                }
            }
        }
        // 最大值一定在以0为起始点，长度为 length - 1 的位置
        return lps[0][length - 1];
    }

    public static void main(String[] args) {
        最长回文子串 func = new 最长回文子串();
        String s = "asdABCBAll";
        System.out.println(func.longestPalindrome(s));
    }
}
