package 剑指offer;

public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,9};
        int res = 0;
        for (int item : arr) {
            res = res ^ item;
        }
        System.out.println(res);
    }
}
