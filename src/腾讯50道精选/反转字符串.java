package 腾讯50道精选;

public class 反转字符串 {
    public void reverseString(char[] s) {
        int p = 0;
        int q = s.length - 1;
        while (p < q){
            swap(s,p,q);
            p ++;
            q--;
        }
    }

    public void swap(char[] s ,int x,int y){
        char tmp = s[x];
        s[x] = s[y];
        s[y] = tmp;
    }
}
