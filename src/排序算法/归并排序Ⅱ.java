package 排序算法;

public class 归并排序Ⅱ {
    public static void main(String[] args) {

    }

    public void sort(int[] arr, int low, int hight) {
        if (low > hight) {
            return;
        }

        int l = low;
        int mid = low + (hight - low) / 2;
        int r = hight;
        int[] tmp = new int[hight - low + 1];
        int k = 0;

        while (l < mid && mid < r) {
            if (arr[l] < arr[mid]){
                tmp[k++] = arr[l++];
            }else{
                tmp[k++] = arr[r++];
            }
        }

        while (l<mid){
            tmp[k++] = arr[l++];
        }

        while (r < hight){
            tmp[k++] = arr[r++];
        }

        k = 0;
        for (int i = low; i < hight; i++) {
            arr[low] = tmp[k++];
        }
    }
}
