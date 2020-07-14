package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:21
 */
public class 快速排序 {
  public static void main(String[] args) {
    int[] a = {1,10,8,9,2,6,4};
    a = QuickSort(a,0,a.length-1);
    System.out.println(Arrays.toString(a));
  }
  /**
   * 快速排序方法
   * @param array
   * @param start
   * @param end
   * @return
   */
  public static int[] QuickSort(int[] array, int start, int end) {
    if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
    int smallIndex = partition(array, start, end);
    if (smallIndex > start)
      QuickSort(array, start, smallIndex - 1);
    if (smallIndex < end)
      QuickSort(array, smallIndex + 1, end);
    return array;
  }
  /**
   * 快速排序算法——partition
   * @param array
   * @param start
   * @param end
   * @return
   */
  public static int partition(int[] array, int start, int end) {
    int pivot = (int) (start + Math.random() * (end - start + 1));
    int smallIndex = start - 1;
    swap(array, pivot, end);
    for (int i = start; i <= end; i++)
      if (array[i] <= array[end]) {
        smallIndex++;
        if (i > smallIndex)
          swap(array, i, smallIndex);
      }
    return smallIndex;
  }

  /**
   * 交换数组内两个元素
   * @param array
   * @param i
   * @param j
   */
  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
