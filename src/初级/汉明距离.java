package 初级;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp!=0){
            if (tmp%2==1){
                count ++;
            }
            tmp = tmp >> 1;
        }
        return count;
    }
}
