package 并查集;

public class 由斜杆划分区域II {
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        int size = 4 * (len * len);
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int index = 4 * (i * len + j);
                // 合并 0 3 、 1 2
                if (chars[j] == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                }
                // 合并0 1、2 3
                else if (chars[j] == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                }
                // 合并 0 1、1 2、1 3
                else {
                    uf.union(index, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }
                // 合并右边的方块,也就是当前的1和右边的3合并
                if (j + 1 < len) {
                    uf.union(index + 1, 4 * (i * len + j + 1) + 3);
                }
                // 合并下发的方块，也就是当前的2和下发的0合并
                if (i + 1 < len) {
                    uf.union(index + 2, 4 * ((i + 1) * len + j));
                }
            }
        }
        return uf.getCount();
    }

    private class UnionFind {
        private int count;
        private int[] parent;

        public int getCount() {
            return count;
        }

        public UnionFind(int count) {
            this.count = count;
            this.parent = new int[count];
            for (int i = 0; i < this.parent.length; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 == root2) {
                return;
            }
            parent[root1] = root2;
            count--;
        }
    }
}
