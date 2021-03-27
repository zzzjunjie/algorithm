package 排序算法;

import java.util.Arrays;

public class 计数排序Ⅱ {
    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 8, 3, 4, 66, 2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        int bias = -min;
        int[] tmp = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            tmp[item + bias]++;
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tmp[index] > 0) {
                arr[i] = index - bias;
                tmp[index]--;
            } else {
                index++;
                i--;
            }
        }
    }
}
