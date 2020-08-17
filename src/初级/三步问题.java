package 初级;

import java.util.Scanner;

/**
 * @author zhou
 * @date 2020/8/16 23:31
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 */
public class 三步问题 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    int i = waysToStep(n);
    System.out.println(i);
  }

  //解法1
  public static int waysToStep(int n) {
    if (n <= 2) {
      return n;
    }
    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i < n+1; i++) {
      //取模，对两个较大的数之和取模再对整体取模，防止越界（这里也是有讲究的）
      //假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）
      //因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
      //但对两个较大的dp[i-n]:dp[i-2],dp[i-3]之和mod 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出
      //取模后变成一个很小的数，与dp[i-1]相加也不溢出
      //所以取模操作也需要仔细分析
      dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % 1000000007) % 1000000007;
    }
    return dp[n];
  }
  //解法2
  public static int waysToStep2(int n) {
    if(n == 1){
      return 1;
    }
    if(n == 2){
      return 2;
    }
    if( n== 3){
      return 4;
    }
    int a = 4;
    int b = 2;
    int c = 1;
    for(int i = 0; i < n - 3; i++){
      int temp_a = a;
      int temp_b = b;
      a = (temp_a + (b + c)% 1000000007)% 1000000007;
      b = temp_a;
      c = temp_b;
    }
    return a;
  }
}
