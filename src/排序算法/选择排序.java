package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:21
 */
public class 选择排序 {
  public static void main(String[] args) {
    int[] a = {1,10,8,9,2,6,4};
    selectionSort(a);
    System.out.println(Arrays.toString(a));
  }
  public static int[] selectionSort(int[] array) {
    if (array.length == 0)
      return array;
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i; j < array.length; j++) {
        if (array[j] < array[minIndex]) //找到最小的数
          minIndex = j; //将最小数的索引保存
      }
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
    return array;
  }
}
