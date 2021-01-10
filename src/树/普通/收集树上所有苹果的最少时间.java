package 树.普通;

import java.util.List;

public class 收集树上所有苹果的最少时间 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 子节点与父节点的对应关系 : 如果[3->5],则a[5]=3
        int[] fatherIndex = new int[n];
        // 把边信息进行转换
        for (int[] edge : edges) {
            fatherIndex[edge[1]] = edge[0];
        }
        int count = 0;
        // 从后往前推
        for (int i = fatherIndex.length - 1; i > 0; i--) {
            if (hasApple.get(i)) {
                // 检测到有苹果则 +1 ,并且假装父节点有苹果
                count++;
                hasApple.set(fatherIndex[i], true);
            }
        }
        // 每条边都需要走两边,一去一回
        return count << 1;
    }
}
