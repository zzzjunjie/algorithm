package 排序算法;

import java.util.Arrays;

public class 堆排序Ⅲ {
    static int len;

    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 4, 8, 2};
        sort(arr);

        while (len > 0) {
            swap(arr, len - 1, 0);
            len--;
            bigTree(arr, 0);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        len = arr.length;

        buildBigTree(arr);

    }

    private static void buildBigTree(int[] arr) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            bigTree(arr, i);
        }
    }

    private static void bigTree(int[] arr, int i) {
        int maxIndex = i;
        if (i * 2 < len && arr[i * 2] > arr[maxIndex]) {
            maxIndex = i * 2;
        }
        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            bigTree(arr, maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int maxIndex) {

        int tmp = arr[i];
        arr[i] = arr[maxIndex];
        arr[maxIndex] = tmp;
    }
}
