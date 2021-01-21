package 树.普通;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
//        int h = (int) Math.log(label-2)+1;
        int h = (int)(Math.log(label)/Math.log(2))+1;
        while(label>1 && h>0){
            list.add(label);
            label =(int)(Math.pow(2,h)-1-label+Math.pow(2,h-1))/2;
            h--;
        }
        list.add(1);
        list.sort(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });

        return list;
    }

    public static void main(String[] args) {
        System.out.println(Math.log(Math.E));
    }
}
