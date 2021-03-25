package 腾讯50道精选;

public class 螺旋矩阵II {
    public static int[][] generateMatrix(int n) {
        int max = n * n;
        int num = 1;
        int[][] res = new int[n][n];
        int r = 0, c = 0;
        int[][] fx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int k = 0;
        while (num <= max) {
            res[r][c] = num;
            num++;
            int r1 = r + fx[k][0], c1 = c + fx[k][1];
            if (r1 < 0 || r1 >= n || c1 < 0 || c1 >= n || res[r1][c1] != 0) {
                k = (k + 1) % 4; // 顺时针旋转至下一个方向
            }
            r = r + fx[k][0];
            c = c + fx[k][1];
        }
        return res;

    }
}
