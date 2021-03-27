package 剑指offer;

public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        // 总的行号和列号
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 定义数组来记录是否已经被走过
        boolean[][] isOk = new boolean[rows][cols];
        // 定义顺时针四个方向 右 下 左 上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 定义结果数组
        int[] res = new int[rows * cols];
        // 初始化行、列、方向
        int row = 0;
        int col = 0;
        int direction = 0;
        // 填充结果数组
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];
            // 记录走过的路径
            isOk[row][col] = true;
            // 下一行
            int nextRow = row + directions[direction][0];
            // 下一列
            int nextCol = col + directions[direction][1];
            // 如果超过边界，就进行下一个方向
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || isOk[nextRow][nextCol]) {
                direction = (direction + 1) % 4;
            }
            row = row + directions[direction][0];
            col = col + directions[direction][1];
        }
        return res;
    }

    public int[] spiralOrder3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
