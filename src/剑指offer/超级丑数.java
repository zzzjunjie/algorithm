package 剑指offer;

import java.util.Arrays;

public class 超级丑数 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] arr = new int[n];
        arr[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < index.length; j++) {
                if (min > arr[index[j]] * primes[j]){
                    min = arr[index[j]] * primes[j];
                }
            }
            arr[i] = min;
            for (int j = 0; j < index.length; j++) {
               if ( arr[index[j]]*primes[j] == min){
                   index[j]++;
               }
            }
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,13,19};
        int i = nthSuperUglyNumber(12, arr);
        System.out.println(i);
    }
}
