package 剑指offer;

public class HapplyNum {
    public static boolean isHapply(int num) {
        if (num <= 0) {
            return false;
        }

        int count = 0;
        while (num != 1 && count < 1000) {
            int tmp = 0;
            while (num != 0) {
                tmp += (num % 10) * (num % 10);
                num = num / 10;
            }
            count++;
            num = tmp;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHapply(19));
    }
}
