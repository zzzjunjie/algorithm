package 剑指offer;


import java.util.HashMap;


/**
 * 缓存淘汰算法-LRU 每次淘汰最近最少使用
 * 哈希表 + 双向链表 实现 哈希表保证其查询速度够快 双向链表保证写入速度够快
 * 思路：
 * 写数据 每次插入节点时，判断该节点是否已经存在
 * 1，存在则删除该节点，然后头插进链表
 * 2，不存在则通过 对比当前链表长度和最大容量 判断当前链表已经满了，满了则先删除链表的尾节点再头插入；没满则直接头插入
 * 以此保证热点数据永远在链表第一位
 * 读数据
 * 读完数据需要调用一次put方法把读的节点放到链表的第一位 保证热点数据永远在第一位
 * 不管是读数据还是写数据都保证热点数据在第一位 当缓存满了需要删除数据的时候直接删除最后一个节点即可 因为该节点的数据永远是最近最少使用的数据
 */
public class LRU {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(10);
		for (int i = 0; i < 10; i++) {
		    cache.put(i,i);
		}
        System.out.println(cache.get(1));
    }


}


//节点
class Node {

	public int key, val;

	public Node next, prev;

	public Node(int k, int v) {
		this.key = k;
		this.val = v;
	}

	@Override
	public String toString() {
		return "Node{" + "key=" + key + ", val=" + val + '}';
	}

}


//双向链表
class DoubleList {

    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;
    public DoubleList() {
        // 初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度，时间 O(1)
    public int size() { return size; }

}


//缓存类
class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        Node x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在 map 中添加 key 的映射
        map.put(key, x);
    }

    /* 删除某一个 key */
    private void deleteKey(int key) {
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从 map 中删除
        map.remove(key);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node deletedNode = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    // 获取
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    // 添加
    public void put(int key, int val){
        addRecently(key,val);
    }
}
