package 腾讯50道精选;

public class 反转字符串中的单词Ⅲ {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            String tmp = str[i];
            char[] chars = tmp.toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                sb.append(chars[j]);
            }
            if (i == str.length - 1) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
