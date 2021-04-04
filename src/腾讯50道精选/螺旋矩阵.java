package 腾讯50道精选;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        // 定义四个方向
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] isOk = new boolean[rows][cols];
        int max = rows * cols;
        int row = 0;
        int col = 0;
        int direction = 0;
        while (max-- >0){
            res.add(matrix[row][col]);
            isOk[row][col] = true;
            int r1 = row + directions[direction][0];
            int c1 = col + directions[direction][1];
            if (r1 <0 || r1>= rows || c1 <0 || c1>=cols || isOk[r1][c1]){
                direction = (direction + 1) %4;
            }
            row = row + directions[direction][0];
            col = col + directions[direction][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(arr);
        System.out.println(list);

    }
}
