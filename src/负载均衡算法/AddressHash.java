package 负载均衡算法;

import java.util.*;

/**
 * 源地址hash
 */
public class AddressHash {
    public static void main (String[] args) {
        List<String> strings = Arrays.asList("192.168.1.1", "192.168.1.2",
                "192.168.1.3",
                "192.168.1.4",
                "192.168.1.1",
                "192.168.1.2",
                "192.168.1.5",
                "192.168.1.1",
                "192.168.1.4",
                "192.168.1.1");
        func(strings,3);
    }

    public static void func (List<String> list,int k){
        Map<String,Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (!res.contains(s)) {
                res.add(s);
            }
        }
        System.out.println("[");
        for (int i = 0; i < k; i++) {
            String s = res.get(i);
            Integer count = map.get(s);
            System.out.println("[\""+s+"\","+count+"]");
        }
        System.out.println("]");
    }
}
