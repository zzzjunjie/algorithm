package 图;

import java.util.ArrayList;
import java.util.List;

public class KruskalⅡ {
    public static void main(String[] args) {
        int[][] graph = {{0, 16, 7, 5, 6}, {16, 0, 6, 9, 8}, {7, 6, 0, 13, 11}, {5, 9, 13, 0, 4}, {6, 8, 11, 4, 0}};
        KruskalⅡ kl = new KruskalⅡ();
        kl.kruskal(5, graph);
    }

    public void kruskal(int n, int[][] graph) {
        UnionFind uf = new UnionFind(n);
        List<Eage> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[0].length; j++) {
                list.add(new Eage(i, j, graph[i][j]));
            }
        }
        // 进行排序
        list.sort(Eage::compareTo);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Eage eage = list.get(i);
            if (uf.union(eage.getX(), eage.getY())) {
                index++;
                System.out.println(eage.getX() + "<------->" + eage.getY() + "=====" + eage.getWeight());
            }
            if (index == n) {
                break;
            }
        }
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return false;
            }
            parent[fx] = fy;
            return true;
        }
    }

    class Eage implements Comparable<Eage> {
        private int x;
        private int y;
        private int weight;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Eage(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Eage o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
