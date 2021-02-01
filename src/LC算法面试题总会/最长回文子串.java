package LC算法面试题总会;

public class 最长回文子串 {
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
                if (i - j < 2) {
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
}
