package 图;

import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Inf = 99;
        int n, m, count, min, minIndex;
        int[][] vertexes;
        boolean[] isConnected;//如果某顶点作为末端顶点被连接，应该为true
        int[] dis;//存储已连接顶点都未连接顶点的最短距离
        int sum = 0;//存储路径长度
        n = in.nextInt();
        m = in.nextInt();
        vertexes = new int[n][n];
        isConnected = new boolean[n];
        dis = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    vertexes[i][j] = 0;
                } else {
                    vertexes[i][j] = Inf;
                }
            }
        }

        for (int i = 0, a, b, c; i < m; i++) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            vertexes[a - 1][b - 1] = c;
            vertexes[b - 1][a - 1] = c;
        }

        //初始化dis数组
        minIndex = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            dis[i] = vertexes[0][i];
        }
        while (count < n) {
            min = Inf;
            //寻找权值最小的
            for (int i = 0; i < n; i++) {
                if (!isConnected[i] && dis[i] < min) {
                    min = dis[i];
                    minIndex = i;
                }
            }
            sum += min;
            //System.out.println(min);
            isConnected[minIndex] = true;
            count++;
            //在minIndex之前的所有顶点已经对dis更新过了
            //所以只需要更新minIndex顶点到其他顶点是否还有更短的距离
            for (int i = 0; i < n; i++) {
                if (!isConnected[i] && dis[i] > vertexes[minIndex][i]) {
                    dis[i] = vertexes[minIndex][i];
                }
            }
        }
        System.out.println(sum);
    }
}
