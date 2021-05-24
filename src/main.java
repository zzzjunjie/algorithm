import 寻路算法.map.Node;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class main {

	private static ThreadLocal<PriorityQueue<Node>> threadlocalOpenList = new ThreadLocal<>();

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.remove(0);
		System.out.println(list);
	}
	private static Integer get(PriorityQueue<Integer> queue,Integer tager){
		for (Integer item : queue) {
			if (item.equals(999999)){
				return item;
			}
		}
		return null;
	}
	private static PriorityQueue<Node> getOpenList() {
		PriorityQueue<Node> openList = threadlocalOpenList.get();
		if (openList == null) {
			openList = new PriorityQueue<>(Comparator.comparingDouble(o -> o.f));
			threadlocalOpenList.set(openList);
		}
		return openList;
	}

}
