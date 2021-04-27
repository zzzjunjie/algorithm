

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
        System.out.println(distance(1,1,5,5));
    }

    public static int getIndex(int x, int z) {
        int minX = -(int) Math.floor(z >> 1);
        if (x < minX) {
            return -1;
        }
        int px = x + z / 2;
        if (px >= 10) {
            return -1;
        }
        int index = px + z * 10;
        if (index < 0 || index >= 100) {
            return -1;
        }
        return index;
    }

    public static int distance(int x, int z, int px, int pz) {
        return (int) ((Math.abs(x - px) + Math.abs((-x-z) - (-px-pz)) + Math.abs(z - pz)) / 2);
    }
}
