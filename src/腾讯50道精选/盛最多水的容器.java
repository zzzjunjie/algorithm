package 腾讯50道精选;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int arr = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(arr, max);

            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }


}
