package 并查集;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 连接所有点的最小费用II {
    public static void main(String[] args) {
        连接所有点的最小费用II func = new 连接所有点的最小费用II();
        int[][] param = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(func.minCostConnectPoints(param));
    }
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        UnionFind uf = new UnionFind(len);
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int distance = distance(points, i, j);
                list.add(new Edge(i,j,distance));
            }
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.len));

        int res = 0;
        int num = 0;
        for (Edge edge : list) {
            if (uf.union(edge.x,edge.y)) {
                res += edge.len;
                num++;
            }
            if (num == len){
                break;
            }
        }
        return res;
    }

    private int distance(int[][] arr,int x,int y){
        return Math.abs(arr[x][0] - arr[y][0]) + Math.abs(arr[x][1]-arr[y][1]);
    }

    private class Edge{
         int x;
         int y;
         int len;

        public Edge(int x,int y,int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", len=" + len +
                    '}';
        }
    }

    private class UnionFind{
        private int[] parent;

        public UnionFind(int n){
            this.parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            if (parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x,int y){
            int fx = find(x);
            int fy = find(y);
            if (fx == fy){
                return false;
            }
            parent[fx] = fy;
            return true;
        }
    }
}
