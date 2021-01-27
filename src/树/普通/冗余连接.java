package 树.普通;

import java.util.Arrays;

public class 冗余连接 {
    public static int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            int index1 = find(parent, node1);
            int index2 = find(parent, node2);
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{1,3},{2,3}};
        int[] redundantConnection = findRedundantConnection(arr);
        System.out.println(Arrays.toString(redundantConnection));
    }
}
