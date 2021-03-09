package 剑指offer;

public class 数组重数 {
    public static int findRepeatNumber(int[] nums) {
        if (nums.length < 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {

                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }


                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }
}
