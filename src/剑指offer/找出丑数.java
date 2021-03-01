package 剑指offer;

public class 找出丑数 {
//    // 判断一个数是不是丑数
//    public static boolean isUglyNumber(int n){
//        while (n % 2 ==0){
//             n = n /2;
//        }
//        while ( n % 3 == 0){
//             n = n / 3;
//        }
//        while (n % 5 == 0){
//            n = n / 5;
//        }
//        return n==1;
//    }
//
//
//    public static int nthUglyNumber(int n){
//        int count = 0;
//        int num = 1;
//        while (true){
//            if (isUglyNumber(num)){
//                count ++;
//            }
//            if (count == n){
//                return num;
//            }
//            num ++;
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println(nthUglyNumber(10));
//    }



    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
