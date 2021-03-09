package 剑指offer;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static int[] exchange(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            while (p < q && nums[p] % 2 == 1) {
                p++;
            }
            while (p < q && nums[q] % 2 == 0) {
                q--;
            }
            if (p < q) {
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        arr = exchange(arr);
        System.out.println(Arrays.toString(arr));
    }
}
