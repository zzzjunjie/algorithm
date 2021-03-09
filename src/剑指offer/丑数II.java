package 剑指offer;

public class 丑数II {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = arr[a] * 2;
            int n3 = arr[b] * 3;
            int n4 = arr[c] * 5;
            int min = Math.min(Math.min(n2, n3), n4);
            arr[i] = min;
            if (min == n2) {
                a++;
            }
            if (min == n3) {
                b++;
            }
            if (min == n4) {
                c++;
            }
        }
        return arr[n - 1];
    }
}
