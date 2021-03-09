package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:18
 */
// 已学会
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 8, 6, 1};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        //遍历每一个数字
        for (int i = 0; i < array.length; i++)
            //把最大的放在数组末尾
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }
}
