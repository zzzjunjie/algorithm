package 腾讯50道精选;

import java.util.Arrays;

// https://leetcode-cn.com/problems/merge-sorted-array/
public class 合并两个有序数组 {

    // 采用插入排序的思想
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }

        for (int i = 0; i < n; i++) {
            int tmp = nums2[i];
            int k = m-1;
            while (k>=0 && nums1[k]>tmp ){
                nums1[k+1] = nums1[k];
                k --;
            }
            nums1[k+1] = tmp;
            m ++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge2(arr,3,arr2,3);
        System.out.println(Arrays.toString(arr));
    }

    // 采用位移的方式
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return ;
        }
        int p1 = m-1;
        int p2 = n-1;

        int p = n + m -1;

        while ((p1>=0) && (p2>=0)){
            nums1[p--] = nums1[p1] > nums2[p2]? nums1[p1--] : nums2[p2--];
        }

        if (p2>=0){
            System.arraycopy(nums2,0,nums1,0,p2+1);
        }
    }
}
