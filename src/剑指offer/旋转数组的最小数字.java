package 剑指offer;

public class 旋转数组的最小数字 {
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            int n = numbers[mid];
            if (n < numbers[high]){
                high = mid;
            }else if (n > numbers[high]){
                low = mid + 1;
            }else{
                high --;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2,3};
        int i = minArray(arr);
        System.out.println(i);
    }
}
