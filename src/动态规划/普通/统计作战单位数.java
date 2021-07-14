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

    public int numTeams(int[] rating) {
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
}
