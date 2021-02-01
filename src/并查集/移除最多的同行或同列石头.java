package 并查集;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 移除最多的同行或同列石头 {
    public int removeStones(int[][] stones) {
        int[] father = new int[stones.length];
        //初始化 自己是自己的上级
        for(int i=0; i<stones.length; i++){
            father[i] = i;
        }

        //查询 合并
        for(int i=0; i<stones.length; i++){
            for(int j=i+1; j<stones.length; j++){
                int x1 = stones[i][0];
                int y1 = stones[i][1];
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                if(x1 == x2 || y1 == y2){
                    union(father, i, j);
                }
            }
        }

        //计算连通分量个数 hash数据结构查询快 set没有重复元素
        HashSet<Integer> res = new HashSet<>();
        for(int i=0; i<father.length; i++){
            res.add(findFather(father, i));
        }
        //结果= 所有石头数 - 连通分量个数
        return stones.length - res.size();
    }

    //合并连通分量
    public void union(int[] father, int x, int y){
        int xFather = findFather(father, x);
        int yFather = findFather(father ,y);
        if(xFather != yFather){
            father[xFather] = yFather;
        }
    }

    //找上级
    public int findFather(int[] father, int x){
        while(father[x] != x){
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    /** 官方解法
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            // 下面这三种写法任选其一
            // unionFind.union(~stone[0], stone[1]);
            // unionFind.union(stone[0] - 10001, stone[1]);
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            count--;
        }
    }
     */
}
