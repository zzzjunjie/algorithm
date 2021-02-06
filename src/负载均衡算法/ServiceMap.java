package 负载均衡算法;

import java.util.HashMap;
import java.util.Map;

public interface ServiceMap {
    Map<String,Integer> IP_ADDRESS_MAP = new HashMap<String,Integer>(){{
        put("192.168.1.100", 1);
        put("192.168.1.101", 1);

        put("192.168.1.102", 4);
        put("192.168.1.103", 1);
        put("192.168.1.104", 1);

        put("192.168.1.105", 3);
        put("192.168.1.106", 1);

        put("192.168.1.107", 2);
        put("192.168.1.108", 1);
        put("192.168.1.109", 1);
        put("192.168.1.110", 1);

    }};
}
