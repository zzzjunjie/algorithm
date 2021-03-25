package 腾讯50道精选;

public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]){
                i++;
                nums[i] =nums[j];
            }
        }
        return i;
    }
}
