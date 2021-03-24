package 腾讯50道精选;

public class 多数元素 {

    // 思路：取众数，然后看看众数是不是出现了len/2次以上
    public int majorityElement(int[] nums) {
        int pre = 0;
        int preCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (preCount>0){
                if (pre == num){
                    preCount ++;
                }else{
                    preCount --;
                }
            }else{
                if (num == pre){
                    preCount ++;
                }else{
                    pre = num;
                    preCount++;
                }
            }
        }

        // 存在一个众数
        if (preCount >0){
            int count = 0;
            for (int num : nums) {
                if (num == pre){
                    count++;
                }
            }
            if (count > nums.length/2){
                return pre;
            }
        }

        return 0;
    }
}
