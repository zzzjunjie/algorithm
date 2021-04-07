

public class main {
    public static String longestPalindrome(String s) {
        // 1.将S字符串转换成char数组，方便计算
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 2.设二维数组dp[j][i],代表位置j到位置i是否为回文子串
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <=i; j++) {
               // 如果两个点之间小于三个元素，则只需要判断头尾是否相同即可
                if (i - j < 2){
                    dp[j][i] = chars[i] == chars[j];
                }else{
                    dp[j][i] = dp[j+1][i-1] && (chars[i] == chars[j]);
                }
                if (dp[j][i] && (i - j + 1)>maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }

        return s.substring(start,start+maxLen);
    }
    public static void main(String[] args) {
        String abcba = longestPalindrome("llkABCBAm");
        System.out.println(abcba);
    }
}
