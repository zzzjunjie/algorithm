package 负载均衡算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 轮询算法
 */
public class RoundRobin {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                func();
            }).start();
        }
    }

    public static void func() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread() + "----" + getAddress());
        }
    }

    private static Integer pos = 0;

    public static String getAddress() {
        Map<String, Integer> map = ServiceMap.IP_ADDRESS_MAP;
        Set<String> addrSet = map.keySet();
        List<String> list = new ArrayList<>(addrSet);

        // 轮询指针需要加锁，在并发的时候可能
        String service = null;
        synchronized (pos) {
            if (pos >= list.size()) {
                pos = 0;
            }
            service = list.get(pos);
            pos++;
        }

        return service;
    }
}
