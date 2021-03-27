package 腾讯50道精选;

public class 二的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        while (n%2==0){
             n = n / 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0){
            return false;
        }
        return  (n & (-n)) == 0;
    }
}
