package 负载均衡算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeightRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(weightRandom());
        }
    }

    public static String weightRandom(){
        Map<String, Integer> addressMap = ServiceMap.IP_ADDRESS_MAP;
        Set<Map.Entry<String, Integer>> entrySet = addressMap.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : entrySet) {
            String key = item.getKey();
            Integer value = item.getValue();

            for (int i = 0; i < value; i++) {
                list.add(key);
            }
        }

        int index = (int) (Math.random() * list.size());
        return list.get(index);

    }
}
