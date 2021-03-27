package 腾讯50道精选;

public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int tmp = 0;
        while (x > tmp) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return x == tmp || x == tmp / 10;
    }
}


