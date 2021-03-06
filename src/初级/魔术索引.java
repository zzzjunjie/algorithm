package 初级;

import java.util.Scanner;

/**
 * @author zhou
 * @date 2020/8/17 0:27
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，
 * 如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 */
public class 魔术索引 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
            if (nums[i] > i) {
                i = nums[i] - 1;//抓住序列是有序的这个点
            }
        }
        return -1;
    }
}
