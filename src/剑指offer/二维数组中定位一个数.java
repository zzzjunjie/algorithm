package 剑指offer;

public class 二维数组中定位一个数 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int tmp = matrix[row][col];
            if (tmp == target) {
                return true;
            }
            if (tmp > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
