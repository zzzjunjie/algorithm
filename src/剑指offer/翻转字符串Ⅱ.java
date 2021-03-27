package 剑指offer;


//给定一个字符串，和一个字符串字串，翻转字符串 但是不翻转字串
public class 翻转字符串Ⅱ {
    public static void main(String[] args) {
        String s = "hello world www.baidu.com/cn";
        String s2 = "world";
        fun(s, s2);
    }

    public static void fun(String s1, String s2) {
        String[] str = s1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals(s2)) {
                sb.append(str[i]);
            } else {
                String tmpStr = str[i];
                char[] tmpChars = tmpStr.toCharArray();
                int p = 0;
                int q = tmpChars.length - 1;
                while (p < q) {
                    swap(tmpChars, p, q);
                    p++;
                    q--;
                }
                sb.append(tmpChars);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }

    public static void swap(char[] chars, int p, int q) {
        char tmp = chars[p];
        chars[p] = chars[q];
        chars[q] = tmp;
    }
}
