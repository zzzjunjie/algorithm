package 并查集;

public class 连通网络的操作次数 {

    private int[] parent;

    public int makeConnected(int n, int[][] connections) {
        // n 个节点相互连通至少需要n-1条线
        if (connections.length < n - 1) {
            return -1;
        }
        // 初始化
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 合并
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count - 1;
    }

    private int find(int node) {
        return parent[node] == node ? node : (parent[node] = find(parent[node]));
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2) {
            return;
        }
        parent[root1] = root2;
    }


    /** 自己的实现
    public int makeConnected(int n, int[][] connections) {
        // 总共的线条数
        int len = connections.length;
        if (n-1 > len){
            return -1;
        }
        // 剩下的线条
        int remain = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < len; i++) {
            int[] row = connections[i];
            int x = row[0];
            int y = row[1];
            if (!uf.union(x,y)) {
                remain ++ ;
            }
        }

        int count = uf.noConnect();
        if (remain - count >=0){
            return count;
        }else{
            return -1;
        }
    }

    private class UnionFind{
        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < this.parent.length; i++) {
                parent[i] = i;
            }
        }

        public int noConnect(){
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i){
                    count++;
                }
            }
            return count>0?count-1:count;
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

        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
     */
}
