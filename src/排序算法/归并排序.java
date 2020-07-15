package 排序算法;

import java.util.Arrays;

/**
 * @author zhou
 * @date 2020/7/14 23:23
 */
public class 归并排序 {
  public static void main(String[] args) {
    int[] a = {1,10,8,9,2,6,4};
//    MergeSort(a);
    int mid = a.length>>1;
    Merge(a,0,mid,a.length-1);
    System.out.println(Arrays.toString(a));
  }

  public static void Merge(int[] array, int low, int mid, int high) {
    if(low>=high)return;
    int i=low;//第一段扫描下标
    int j=mid+1;//第二段扫描下标
    int[] array2 = new int[high-low+1];//临时数组
    int k=0;//临时数组下标
    // 扫描第一段和第二段序列，直到有一个扫描结束

    Merge(array,i,(i+mid)>>1,mid);
    Merge(array,j,(j+high)>>1,high);

    while (i<=mid && j <=high){
      // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
      if(array[i]<=array[j]){
        array2[k]=array[i];
        i++;
        k++;
      }else {
        array2[k]=array[j];
        j++;
        k++;
      }
    }

    //如果是左边没扫描完，把左边剩余的元素插入临时数组
    while (i<=mid){
      array2[k]=array[i];
      k++;
      i++;
    }
    //如果是右边没扫描完，把右边剩余的元素插入临时数组
    while (j<=high){
      array2[k]=array[j];
      k++;
      j++;
    }

    // 将合并序列复制到原始序列中
    for (k = 0, i = low; i <= high; i++, k++) {
      array[i] = array2[k];
    }
  }
  //-------------------------------------------------------------------------------------------------
  /**
   * 归并排序
   *
   * @param array
   * @return
   */
  public static int[] MergeSort(int[] array) {
    if (array.length < 2) return array;
    int mid = array.length / 2;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, array.length);
    return merge(MergeSort(left), MergeSort(right));
  }
  /**
   * 归并排序——将两段排序好的数组结合成一个排序数组
   *
   * @param left
   * @param right
   * @return
   */
  public static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    for (int index = 0, i = 0, j = 0; index < result.length; index++) {
      if (i >= left.length)
        result[index] = right[j++];
      else if (j >= right.length)
        result[index] = left[i++];
      else if (left[i] > right[j])
        result[index] = right[j++];
      else
        result[index] = left[i++];
    }
    return result;
  }
}
