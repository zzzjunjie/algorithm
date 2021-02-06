package 负载均衡算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 源地址hash
 */
public class AddressHash {
    public static void main(String[] args) {
        System.out.println(addressHash("192.168.1.1"));
        System.out.println(addressHash("192.168.1.1"));
        System.out.println(addressHash("192.168.1.1"));
        System.out.println(addressHash("192.168.1.1"));

        System.out.println(addressHash("192.168.1.2"));
        System.out.println(addressHash("192.168.1.3"));
        System.out.println(addressHash("192.168.1.4"));

        System.out.println(addressHash("192.168.1.2"));
        System.out.println(addressHash("192.168.1.3"));
        System.out.println(addressHash("192.168.1.4"));


    }

    public static String addressHash(String address) {
        List<String> list = new ArrayList<>(ServiceMap.IP_ADDRESS_MAP.keySet());
        int hashCode = address.hashCode();
        int index = hashCode % list.size();
        return list.get(index);

    }
}
