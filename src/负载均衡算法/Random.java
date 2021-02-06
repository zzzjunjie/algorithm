package 负载均衡算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机负载
 */
public class Random {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(random());

        }
    }

    public static String random() {
        List<String> list = new ArrayList<>(ServiceMap.IP_ADDRESS_MAP.keySet());
        int index = (int) (Math.random()*list.size());
        return list.get(index);

    }
}
