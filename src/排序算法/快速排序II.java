package 排序算法;

import javafx.scene.control.RadioMenuItem;

import java.util.Arrays;
import java.util.Random;

public class 快速排序II {
    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);
    }
    //
    public static void quickSort(int[] arr,int l,int r){
        if (l<r){
            int helper = helper(arr, l, r);
            quickSort(arr,l,helper-1);
            quickSort(arr,helper+1,r);
        }
    }

    public static int helper(int[] arr,int left,int right){
        int base = arr[left];
        while (left<right){
            while (left<right && arr[right] >=base){
                right --;
            }
            swap(arr,left,right);
            while (left<right && arr[left] <=base){
                left++;
            }
            swap(arr,left,right);
        }
        arr[left] = base;
        return left;
    }

    public int hepler2(int[] arr,int l,int r){
        int random = (int) (l + (r - l + 1) * Math.random());
        swap(arr,random,r);
        int smallIndex = l - 1;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= arr[r]){
                smallIndex++;
                if (i> smallIndex){
                    swap(arr,i,smallIndex);
                }
            }
        }
        return smallIndex;
    }
    private static void swap(int[] arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
