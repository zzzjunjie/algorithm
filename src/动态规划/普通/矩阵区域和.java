package 动态规划.普通;

public class 矩阵区域和 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 左上角坐标
                int r1 = Math.max(i - K, 0);
                int c1 = Math.max(j - K, 0);
                // 右下角坐标
                int r2 = Math.min(i + K, row - 1);
                int c2 = Math.min(j + K, col - 1);
                res[i][j] = dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
            }
        }
        return res;
    }
}
