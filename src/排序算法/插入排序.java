package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:22
 */
public class 插入排序 {
  public static void main(String[] args) {
    int[] a = {1,10,8,9,2,6,4};
    insertionSort(a);
    System.out.println(Arrays.toString(a));
  }
  /**
   * 插入排序
   * @param array
   * @return
   */
  public static int[] insertionSort(int[] array) {
    if (array.length == 0)
      return array;
    int current;
    for (int i = 0; i < array.length - 1; i++) {
      current = array[i + 1];
      int preIndex = i;
      while (preIndex >= 0 && current < array[preIndex]) {
        array[preIndex + 1] = array[preIndex];
        preIndex--;
      }
      array[preIndex + 1] = current;
    }
    return array;
  }
}
