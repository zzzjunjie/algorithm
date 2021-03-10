package 排序算法;

import java.util.Arrays;

public class 堆排序Ⅱ {
    public static void main(String[] args) {
        int[] arr = {1,9,5,8,3,4,7,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int len;
    public static void sort(int[] arr){
        len = arr.length;
        if (arr.length<=0){
            return;
        }
//        // 初始化数组为大顶堆 从小到大排
//        BuildHeaps(arr);
//
//        for (int i = len-1; i >0 ; i--) {
//            swap(arr,i,0);
//            len --;
//            adjust(arr,0);
//        }

        // 构建小顶堆，从大往小排
        buildMinHeaps(arr);
        for (int i = len-1; i >0 ; i--) {
            swap(arr,i,0);
            len--;
            min(arr,0);
        }
    }

    // ---------------------构建大堆树，从小->大排序--------------------------------------------
    public static void BuildHeaps(int[] arr){
        for (int i = (len - 1) / 2; i >=0; i--) {
            adjust(arr,i);
        }
    }

    public static void adjust(int[] arr,int index){
       int maxIndex = index;
       if (index * 2 < len && arr[index * 2] > arr[maxIndex]){
           maxIndex = index * 2;
       }
       if (index * 2 + 1 <len && arr[index * 2 + 1] > arr[maxIndex]){
           maxIndex = index * 2 + 1;
       }
       if (maxIndex != index){
          swap(arr,maxIndex,index);
          adjust(arr,maxIndex);
       }
    }

    // ---------------------构建小堆树，从大->小排序--------------------------------------------
    public static void buildMinHeaps(int[] arr){
        for (int i = (len-1)/2; i >=0; i--) {
            min(arr,i);
        }
    }

    public static void min(int[] arr,int index){
        int minIndex = index;
        if (index * 2 < len && arr[index * 2] < arr[minIndex]){
            minIndex = index * 2;
        }
        if (index * 2 + 1 < len && arr[index * 2 + 1] < arr[minIndex]){
            minIndex = index * 2 + 1;
        }
        if (minIndex != index){
            swap(arr,minIndex,index);
            min(arr,minIndex);
        }
    }


    public static void swap(int[]arr,int p,int q){
        if (p==q){
            return;
        }
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
