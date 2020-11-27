package LC算法面试题总会;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 快乐数 {
    /**
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为 1，那么这个数就是快乐数。
     * 输入：19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm3y2i/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> cache = new HashSet<>();
        while (true) {
            char[] chars = String.valueOf(n).toCharArray();
            n = 0;
            for (char c : chars) {
                int a = c - 48;
                n += Math.pow(a, 2);
            }
            if (n == 1) {
                return true;
            }
            if (cache.contains(n)) {
                break;
            }
            cache.add(n);
        }
        return false;
    }
}
