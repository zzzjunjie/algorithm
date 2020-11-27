package 位运算;

import java.util.Arrays;
import java.util.Random;

//去重
public class Demo01 {
  public static void main(String[] args) {
    int N = 11;
    int[] arr = new int[N];
    for (int i=0;i<N-1;i++){
      arr[i]=i+1;
    }
    arr[N-1] =new Random().nextInt(N-1)+1;
    System.out.println(Arrays.toString(arr));
    int x = 0;
    for (int i=0;i<N-1;i++){
      x = x^i+1;
    }
    for (int i=0;i<N;i++){
      x = x^arr[i];
    }
    System.out.println(x);
  }
}
