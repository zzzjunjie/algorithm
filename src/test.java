import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class test {


    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>(2,1);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            map.put(0,0);
        }

        new ReentrantLock();
    }
}
