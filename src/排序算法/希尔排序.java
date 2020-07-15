package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:23
 */
public class 希尔排序 {
  public static void main(String[] args) {
    int[] a = {1,10,8,9,2,6,4,12};
    ShellSort(a);
    System.out.println(Arrays.toString(a));
  }
  /**
   * 希尔排序
   *
   * @param array
   * @return
   */
  public static int[] ShellSort(int[] array) {
    int len = array.length;
    int temp, gap = len / 2;
    while (gap > 0) {
      for (int i = gap; i < len; i++) {
        temp = array[i];
        int preIndex = i - gap;
        while (preIndex >= 0 && array[preIndex] > temp) {
          array[preIndex + gap] = array[preIndex];
          preIndex -= gap;
        }
        array[preIndex + gap] = temp;
      }
      gap /= 2;
    }
    return array;
  }
}
