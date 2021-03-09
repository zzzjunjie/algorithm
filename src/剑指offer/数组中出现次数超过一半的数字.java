package 剑指offer;

import java.util.HashMap;
import java.util.Map;
//[1,2,3,2,2,2,5,4,2]
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int res = majorityElement(arr);
        System.out.println(res);
    }
    // 思路：取众数，然后根据众数去判断是否出想过len/2次；时间复杂度为O(n),但是空间复杂度可以下降到O(1)
    public static int majorityElement(int[] nums) {
        int pre = 0;
        int preCount = 0;
        for (int num : nums) {
            if (num == pre){
                preCount ++;
            }else{
                if (preCount > 0) {
                    preCount --;
                }else{
                    pre = num;
                    preCount ++;
                }
            }
        }
        if (preCount > 0){
            int count = 0;
            for (int num : nums) {
                if (num == pre){
                    count++;
                }
            }
            return count>nums.length>>1?pre:0;
        }
        return 0;
    }

    // O(n)
    public int majorityElement1(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
            if (map.get(num) > max){
                max = map.get(num);
                res = num;
            }
        }
        return max>nums.length>>2?res:0;
    }
}
