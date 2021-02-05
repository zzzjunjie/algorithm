package 图;

import javax.crypto.interfaces.PBEKey;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static void main(String[] args) {
        int[][] graph = {{0,2,3,5},{2,0,6,4},{3,6,0,1},{5,4,1,0}};
        Kruskal kruskal = new Kruskal();
        kruskal.Kruskal(4,graph);
    }

    public void Kruskal(int n,int[][] graph){
        List<Eage> res = new ArrayList<>();
        List<Eage> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = i+1; j < graph[i].length; j++) {
                list.add(new Eage(i,j,graph[i][j]));
            }
        }
        UnionFind uf = new UnionFind(n);
        list.sort(Comparator.comparingInt(Eage::getWeight));

        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            Eage eage = list.get(i);
            if (uf.union(eage.getX(),eage.getY())) {
                res.add(eage);
                num ++;
            }
            if (num==n-1){
                break;
            }
        }
        print(res);
    }
    private void print(List<Eage> res ){
        for (Eage item : res) {
            System.out.println(item.getX()+"<----->"+item.getY()+"------"+item.getWeight());
        }
    }


    public class UnionFind{
        int[] parent ;

        public UnionFind(int n){
            this.parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i]=i;
            }
        }

        public int find(int x){
            if (parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return x;
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

    public class Eage{
        private int x;
        private int y;
        private int weight;

        public Eage(int x,int y,int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
        }
    }
}
