package 并查集;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class 省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            int[] ints = isConnected[i];
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] == 1) {
                    union(parent, ints[i], ints[j]);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    public void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    public int find(int[] parent, int targe) {
        if (parent[targe] != targe) {
            parent[targe] = find(parent, parent[targe]);
        }
        return parent[targe];
    }

}
