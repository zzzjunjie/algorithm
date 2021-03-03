import java.util.ArrayDeque;
import java.util.Deque;

public class test {


    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque.poll());
        System.out.println(deque.poll());
    }
}
