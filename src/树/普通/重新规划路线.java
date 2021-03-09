package 树.普通;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */

/**
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 重新规划路线 {
    public int minReorder(int n, int[][] connections) {
        //BFS辅助队列
        Queue<Integer> vertex = new LinkedList<Integer>();
        //存储有向图的顶点以及关联的弧
        Map<Integer, HashSet<int[]>> graph = new HashMap<>();
        int ans = 0;
        for (int[] e : connections) {
            if (!graph.containsKey(e[0])) {
                graph.put(e[0], new HashSet<int[]>());
            }
            graph.get(e[0]).add(e);
            if (!graph.containsKey(e[1])) {
                graph.put(e[1], new HashSet<int[]>());
            }
            graph.get(e[1]).add(e);
        }
        //从顶点0开始遍历该有向图
        vertex.offer(0);
        while (!vertex.isEmpty()) {
            //出队访问
            int ver = vertex.poll();
            //暂存该顶点关联的所有边
            HashSet<int[]> hashtemp = graph.get(ver);
            //从graph中移除已经访问过的顶点
            graph.remove(ver);
            for (int[] e : hashtemp) {
                if (e[0] != ver && graph.containsKey(e[0])) {
                    vertex.offer(e[0]);
                }
                //e[1]!=ver,说明e[0]=ver,则该边是逆向边
                if (e[1] != ver && graph.containsKey(e[1])) {
                    vertex.offer(e[1]);
                    ans++;
                }
            }
        }
        return ans;
    }
}
