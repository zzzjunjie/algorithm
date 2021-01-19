package 树.普通;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        //0.初始化存放结果的变量
        ArrayList<Integer> integers = new ArrayList<>();
        //2.计算label所在的层
        int a = (int) (Math.log(label) / Math.log(2));
        //5.循环直到遇到特殊情况1
        while (label > 1) {
            //3.将label的结果添加到数组中
            integers.add(label);
            //4.计算下一个label的值
            label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);
        }
        //6.添加特殊情况 1
        integers.add(1);
        //7.翻转数组
        Collections.reverse(integers);
        //1.返回结果
        return integers;
    }

    public static void main(String[] args) {
        int a = (int) (Math.log(7) / Math.log(2));
        System.out.println(a);
    }
}
