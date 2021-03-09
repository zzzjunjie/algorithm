package LC算法面试题总会;

import java.util.ArrayList;
import java.util.List;

public class 加油站 {
    public static void main(String[] args) {

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                list.add(i);
            }
        }

        for (int n = 0; n < list.size(); n++) {

            int j = list.get(n);
            int sum = gas[j];
            //System.out.println(list.get(n));
            while (j < gas.length - 1) {
                sum = sum - cost[j];
                if (sum < 0) {
                    break;
                }
                j++;
                sum += gas[j];
            }
            sum -= cost[j];

            if (sum < 0) {
                continue;
            }
            j = 0;
            sum = sum + gas[j];
            while (j != list.get(n)) {
                //System.out.println(",,,,,,,");
                sum = sum - cost[j];
                if (sum < 0) {
                    break;
                }
                j++;
                sum += gas[j];
            }
            sum -= cost[list.get(n)];
            if (sum >= 0) {
                //System.out.println(list.get(n));
                return list.get(n);
            }

        }
        return -1;
    }
}
