package 负载均衡算法;

import javafx.print.PageOrientation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 加权轮询算法
 */
public class WeightRoundRobin {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                func();
            }).start();
        }
    }

    public static void func() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread() + "----" + weightRoundRobin());
        }
    }

    private static Integer pos = 0;

    public static String weightRoundRobin() {
        Map<String, Integer> addressMap = ServiceMap.IP_ADDRESS_MAP;
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : addressMap.entrySet()) {
            String key = item.getKey();
            Integer value = item.getValue();
            for (int i = 0; i < value; i++) {
                list.add(key);
            }
        }
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
