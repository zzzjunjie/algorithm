package 腾讯50道精选;

public class 数组中的第K个最大元素 {
    //    public int findKthLargest(int[] nums, int k) {
//        int heapSize = nums.length;
//        buildMaxHeap(nums, heapSize);
//        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
//            swap(nums, 0, i);
//            --heapSize;
//            maxHeapify(nums, 0, heapSize);
//        }
//        return nums[0];
//    }
//
//    public void buildMaxHeap(int[] a, int heapSize) {
//        for (int i = heapSize / 2; i >= 0; --i) {
//            maxHeapify(a, i, heapSize);
//        }
//    }
//
//    public void maxHeapify(int[] a, int i, int heapSize) {
//        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
//        if (l < heapSize && a[l] > a[largest]) {
//            largest = l;
//        }
//        if (r < heapSize && a[r] > a[largest]) {
//            largest = r;
//        }
//        if (largest != i) {
//            swap(a, i, largest);
//            maxHeapify(a, largest, heapSize);
//        }
//    }
//
//    public void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        //  构建大顶堆
        buildMaxHeap(nums,heapSize);
        //  将最大的数放到数组最后一个
        for (int i = heapSize-1; i >=nums.length +1 - k ; i--) {
            swap(nums,0,i);
            heapSize -- ;
            maxHeap(nums,0,heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = nums.length / 2 ; i >= 0; i--) {
            maxHeap(nums,i,heapSize);
        }
    }

    public static void maxHeap(int[] nums, int index, int heapSize) {
        int i = index;
        if (index * 2 < heapSize && nums[i] < nums[index * 2]) {
            i = index * 2;
        }
        if (index * 2 + 1 < heapSize && nums[i] < nums[index * 2 + 1]) {
            i = index * 2 + 1;
        }
        if (i != index) {
            swap(nums, i, index);
            maxHeap(nums, i, heapSize);
        }
    }

    public static void swap(int[] nums, int p, int q) {
        nums[p] = nums[p] + nums[q];
        nums[q] = nums[p] - nums[q];
        nums[p] = nums[p] - nums[q];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int kthLargest = findKthLargest(arr, 1);
        System.out.println(kthLargest);
    }
}
