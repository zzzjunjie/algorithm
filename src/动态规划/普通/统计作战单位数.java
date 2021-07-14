package 动态规划.普通;

public class 统计作战单位数 {

    public int numTeams1(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        res++;
                    }

                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int numTeams2(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftDown = 0;
            int rightDown = 0;
            int leftUp = 0;
            int rightUp = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftDown++;
                } else {
                    leftUp++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rightDown++;
                } else {
                    rightUp++;
                }
            }
            res += leftDown * rightUp + leftUp * rightDown;
        }
        return res;
    }

    public int numTeams3(int[] rating) {
        /*
        找多少个升序组合和多少个降序组合

        up 记录从左到右升序， down 记录从左到右降序
        up 和 down 记录 [0, i - 1] 有多少个 比 i 小的 和 比 i 大的

        规定 j < i，我们固定 i 和 j，然后根据 rating[j] 和 rating[i] 的关系进行处理
        如果 rating[j] > rating[i]，那么就相当于是降序，那么我们找 j 前面有多少个比 j 大的元素，这些元素每一个都能够跟 j 和 i 构成组合，即 c += down[j]
        如果 rating[j] < rating[i]，那么就相当于是升序，那么我们找 j 前面有多少个比 j 小的元素，这些元素每一个都能够跟 j 和 i 构成组合，即 c += up[j]
        如果 rating[j] == rating[i]，直接忽略

        状态可以压缩的，这里方便理解就不整了
        */
        int len = rating.length;
        int[] up = new int[len];
        int[] down = new int[len];

        int c = 0;
        for(int i = 0; i < len; i++){
            for(int j = i - 1; j >= 0; j--){
                //比它大，找降序
                if(rating[j] > rating[i]){
                    c += down[j];
                    down[i]++;
                }else if(rating[j] < rating[i]){
                    c += up[j];
                    up[i]++;
                }
            }
        }
        return c;
    }
}
