package 并查集;

import java.util.HashMap;
import java.util.Map;

public class 移除最多的同行或同列石头 {

    public int removeStones(int[][] stones) {
        int len = stones.length;
        UnionFind uf = new UnionFind();
        for (int i = 0; i < len; i++) {
            uf.union(~stones[i][0],stones[i][1]);
        }
        return len - uf.getCount();
    }

    private class UnionFind{
        private Map<Integer,Integer> map;
        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind() {
            this.map = new HashMap<>();
            this.count = 0;
        }

        public int find(int x){
            if (!map.containsKey(x)) {
                map.put(x,x);
                count++;
            }
            if (map.get(x)!=x){
                map.put(x,find(map.get(x)));
            }
            return map.get(x);
        }

        public void union(int x,int y){
            int fx = find(x);
            int fy = find(y);
            if (fx!=fy){
                map.put(map.get(fx),fy);
                count--;
            }
        }
    }



//    public int removeStones(int[][] stones) {
//        int len = stones.length;
//        int[] parent  = new int[len];
//        for (int i = 0; i < parent.length; i++) {
//            parent[i] = i;
//        }
//        for (int i = 0; i < stones.length; i++) {
//            for (int j = i+1; j < stones.length; j++) {
//                int x1 = stones[i][0];
//                int y1 = stones[i][1];
//                int x2 = stones[j][0];
//                int y2 = stones[j][1];
//                // 在同一行或者同一列的两个顶点进行合并
//                if (x1==x2 || y1 == y2) {
//                    union(parent,i,j);
//                }
//            }
//        }
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < len; i++) {
//            set.add(find(parent,i));
//        }
//        return len - set.size();
//    }
//
//    private int find(int[] parent,int x){
//        if (parent[x] != x){
//            parent[x] = find(parent,parent[x]);
//        }
//        return parent[x];
//    }
//
//    public void union(int[] parent,int x,int y){
//        int fx = find(parent, x);
//        int fy = find(parent, y);
//        if (fx!=fy){
//            parent[fx] = fy;
//        }
//    }

    // 官方解法
//    public int removeStones(int[][] stones) {
//        UnionFind unionFind = new UnionFind();
//
//        for (int[] stone : stones) {
//            // 下面这三种写法任选其一
//            // unionFind.union(~stone[0], stone[1]);
//            // unionFind.union(stone[0] - 10001, stone[1]);
//            unionFind.union(stone[0] + 10001, stone[1]);
//        }
//        return stones.length - unionFind.getCount();
//    }
//
//    private class UnionFind {
//
//        private Map<Integer, Integer> parent;
//        private int count;
//
//        public UnionFind() {
//            this.parent = new HashMap<>();
//            this.count = 0;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public int find(int x) {
//            if (!parent.containsKey(x)) {
//                parent.put(x, x);
//                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
//                count++;
//            }
//
//            if (x != parent.get(x)) {
//                parent.put(x, find(parent.get(x)));
//            }
//            return parent.get(x);
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return;
//            }
//
//            parent.put(rootX, rootY);
//            // 两个连通分量合并成为一个，连通分量的总数 -1
//            count--;
//        }
//    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println(~a);
    }
}
