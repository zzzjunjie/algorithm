package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:21
 */
public class 选择排序 {
  public static void main(String[] args) {
    int[] a = {1,10,8,9,2,6,4};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void sort(int[] list){
    if(list.length<0)return ;
    for(int i=0;i<list.length;i++){
      int min = i;
      for(int j=i+1;j<list.length;j++){
        if(list[min]>list[j]){
          min = j;
        }
      }
      int temp = list[min];
      list[min] = list[i];
      list[i] = temp;
    }
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
