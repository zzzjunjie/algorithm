package 腾讯50道精选;

//https://leetcode-cn.com/problems/longest-common-prefix/
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length==0){
            return "";
        }
        int index  = 0;
        StringBuilder res = new StringBuilder();
        char[] chars = new char[length];
        while (true){
            for (int i = 0; i < length; i++) {
                String str = strs[i];
                if (index>=str.length()){
                    return str;
                }
                chars[i] = str.charAt(index);
            }
            char tmp = chars[0];
            for (int i =1; i < length; i++) {
                if (chars[i]!=tmp){
                    return res.toString();
                }
            }
            index++;
            res.append(tmp);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}

