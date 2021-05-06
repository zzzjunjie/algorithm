package 寻路算法.jsp;


import 寻路算法.Finder;
import 寻路算法.map.MapData;
import 寻路算法.map.Node;

import java.util.*;


// https://www.woaifaming.net/doc/257464.html 算法启发
// 定义单方向搜索为: ↖ ↙ →，双方向搜索为: ← ↗ ↘
// 顺序为：	↘:（X+1，Y-1）  	X>0,Y<0
//			→:(X+1,Y) 		X>0,Y=0
//			↗:(X,Y+1) 		X=0,Y>0
//			↖:(X-1，Y+1)	X<0,Y>0
//			←:(X-1，Y) 		X<0,Y=0
//			↙:(X,Y-1)		X=0,Y<0
//----------------------------------
// 单方向:	↖:(X-1，Y+1)	X<0,Y>0
//			→:(X+1,Y) 		X>0,Y=0
//			↙:(X,Y-1)		X=0,U<0
//----------------------------------
// 双方向:	↗:(X,Y+1) 		X=0,Y>0
//			←:(X-1，Y) 		X<0,Y=0
//			↘:（X+1，Y-1）  	X>0,Y<0
//----------------------------------
public class HexagonJPS extends Finder {

	/** 邻居节点，中间计算使用 */
	protected final List<Node> neighbors = new ArrayList<>();

	// 方向节点，这里要注意和客户端的地图格子方向对应，否则寻不到正常的路径。
	// 我们的地图格子取巧用了两个坐标保持不变，这样就没有坐标偏差，但同时存储空间的浪费也比较严重;计算起来就比较简单，如果有坐标偏差的话要使用偏差路径
	// 规定了 1 3 5 为单方向前进、0 2 4 为多方向前进
	private final List<Node> DIR = Arrays.asList(new Node(0, 1),    // 东北方向 ↗
			new Node(1, 0),		// 正东方向 →
			new Node(1, -1), 		// 东南方向 ↘
			new Node(0, -1), 		// 西南方向 ↙
			new Node(-1, 0), 		// 正西方向 ←
			new Node(-1, 1));  	// 西北方向 ↖

	// JPS采用优先队列进行搜索，操作起来更加方便简单，如果想要用二叉堆的话，也可以使用TreeSet
	// 使用优先级队列，根据每个节点的f权重进行排序
	private final PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingDouble(o->o.f));

	// 走过的节点的hashCode放入这里
	private final Set<Integer> closed = new HashSet<>();
	public HexagonJPS(MapData mapData) {
		super(mapData);
	}
	@Override
	public List<Node> findPath(Node start, Node end) {
		openList.clear();
		neighbors.clear();
		// 初始化开始节点到终点的距离权重值
		calcF(start, end);
		// 开始点加入openList中
		openList.add(start);
		Node top;
		// 从OpenList中拿出所有的跳点，进行遍历
		while (!openList.isEmpty()) {
			// 从OpenList中拿出f值最小的点弹出
			top = openList.poll();
			// 已经使用过的点就加入到CloseList中
			closed.add(top.hashCode());
			// 寻到了目标点
			if (top.equals(end)) {
				return backtrace(top);
			}
			identifySuccessors(top, end);
		}
		return Collections.emptyList();
	}

	// 从最后一个回溯到第一个节点，采用链表头插法
	private List<Node> backtrace(Node node) {
		if (node == null)
			return null;
		LinkedList<Node> paths = new LinkedList<>();
		paths.addFirst(node);
		while (node.pre != null) {
			paths.addFirst(node.pre);
			node = node.pre;
		}
		return paths;
	}

	private void identifySuccessors(Node node, Node endNode) {
		findNeighbors(node, endNode);
		double new_jump_g;
		for (Node neighbor : neighbors) {
			// 获取跳点
			Node jumpNode = jump(neighbor, node, endNode);
			if (jumpNode==null || closed.contains(jumpNode.hashCode())) {
				continue;
			}
			// log.error("加入跳点为:{}", jumpNode);
			// 到达终点了
			if (jumpNode.equals(endNode)) {
				jumpNode.pre =node;
				jumpNode.f = -1;
				openList.add(jumpNode);
				return;
			}
			// 计算跳点的g值
			new_jump_g = node.g + getDistance(jumpNode.x - node.x, jumpNode.y - node.y);
			if (!openList.contains(jumpNode) || new_jump_g < jumpNode.g) {
				jumpNode.pre = node;
				jumpNode.g = new_jump_g;
				calcF(jumpNode, endNode);
				// 移除不移除都可以，有close表
				if (openList.contains(jumpNode)) {
					openList.remove(jumpNode);
				}
				openList.add(jumpNode);
			}
		}
		// log.error("跳点列表为：【{}】",openList);
	}

	/**
	 * 跳点寻找
	 *
	 * @param neighbor 邻居节点
	 * @param current  当前节点
	 * @param end      终点
	 */
	private Node jump(Node neighbor, Node current, Node end) {
		if (neighbor == null) {
			return null;
		}
		// 超出地图
		if (!reachable(current, neighbor.x, neighbor.y)) {
			return null;
		}
		// 当前点就是终点的时候返回
		if (neighbor.equals(end)) {
			return neighbor;
		}
		int dx = neighbor.x - current.x;
		int dy = neighbor.y - current.y;
		// 判断当前的方向是如何的
		Node direction = new Node(dx, dy);
		int index = DIR.indexOf(direction);
		// 如果自己方向的左120°是障碍物且左60°不是障碍物 或 自己方向的右120°是障碍物且右60°不是障碍物，那么这个点就是跳点
		int leftIndex_120 = index - 2 < 0 ? index - 2 + 6 : index - 2;
		int leftIndex_60 = index - 1 < 0 ? index - 1 + 6 : index - 1;
		int rightIndex_120 = (index + 2) % 6;
		int rightIndex_60 = (index + 1) % 6;
		Node left_120 = DIR.get(leftIndex_120);
		Node left_60 = DIR.get(leftIndex_60);
		Node right_120 = DIR.get(rightIndex_120);
		Node right_60 = DIR.get(rightIndex_60);

		// 三个单方向搜索
		if (index == 1 || index == 3 || index == 5) {
			if ((!reachable(current, neighbor.x + left_120.x, neighbor.y + left_120.y) && reachable(current, neighbor.x + left_60.x, neighbor.y + left_60.y))
					|| (!reachable(current, neighbor.x + right_120.x, neighbor.y + right_120.y) && reachable(current, neighbor.x + right_60.x,
					neighbor.y + right_60.y))) {
				return neighbor;
			}
		}

		// 三个多方向搜索
		if (index == 0 || index == 2 || index == 4) {
			if (jump(new Node(neighbor.x + left_60.x, neighbor.y + left_60.y), neighbor, end) != null) {
				return neighbor;
			}
			if (jump(new Node(neighbor.x + right_60.x, neighbor.y + right_60.y), neighbor, end) != null) {
				return neighbor;
			}
		}
		return jump(new Node(neighbor.x + dx, neighbor.y + dy), neighbor, end);
	}

	/**
	 * 查找当前节点的邻居节点
	 *
	 * @param node 当前节点
	 */
	private void findNeighbors(Node node, Node end) {
		neighbors.clear();
		// 如果当前的节点父节点为null，那么证明当前节点是startNode
		if (node.pre == null) {
			getNeighborsAll(node, end);
			return;
		}
		// 有前节点的时候，忽略劣质节点
		// 0:X同方向 1:下面 -1:上面
		int dx = 0;
		// 当前节点在父节点的下方
		if (node.x > node.pre.x) {
			dx = 1;
		}
		// 当前节点在父节点的上方
		else if (node.x < node.pre.x) {
			dx = -1;
		}

		// 0:Y同放下 1:右边 -1:左边
		int dy = 0;
		// 当前节点在父节点的右边
		if (node.y > node.pre.y) {
			dy = 1;
		}
		// 当前节点在父节点的左边
		else if (node.y < node.pre.y) {
			dy = -1;
		}
		// 当前节点前进的方向
		Node direction = new Node(dx, dy);
		int index = DIR.indexOf(direction);
		// 计算当前节点左60°、120°和右60°、120°节点；
		// 如果左120°为障碍物且左60°非障碍物，则该节点可以认为有强迫邻居节点，需要把强迫邻居也加入到邻居列表中
		// 同理，如果右120°为障碍物且右60°非障碍物，则该节点可以认为有强迫邻居节点，需要把强迫邻居也加入到邻居列表中
		int leftIndex_60 = index - 1 < 0 ? index - 1 + 6 : index - 1;
		int leftIndex_120 = index - 2 < 0 ? index - 2 + 6 : index - 2;
		int rightIndex_120 = (index + 2) % 6;
		int rightIndex_60 = (index + 1) % 6;
		Node left_120 = DIR.get(leftIndex_120);
		Node left_60 = DIR.get(leftIndex_60);
		Node righ_120 = DIR.get(rightIndex_120);
		Node righ_60 = DIR.get(rightIndex_60);

		// 当前方向
		if (reachable(node, node.x + direction.x, node.y + direction.y)) {
			neighbors.add(new Node(node.x + direction.x, node.y + direction.y));
		}

		if (direction.equals(DIR.get(1)) || direction.equals(DIR.get(3)) || direction.equals(DIR.get(5))) {
			if (!reachable(node, node.x + left_120.x, node.y + left_120.y)) {
				if (reachable(node, node.x + left_60.x, node.y + left_60.y)) {
					neighbors.add(new Node(node.x + left_60.x, node.y + left_60.y));
				}
			}
			if (!reachable(node, node.x + righ_120.x, node.y + righ_120.y)) {
				if (reachable(node, node.x + righ_60.x, node.y + righ_60.y)) {
					neighbors.add(new Node(node.x + righ_60.x, node.y + righ_60.y));
				}
			}
		}

		// 三个多方向
		if (direction.equals(DIR.get(0)) || direction.equals(DIR.get(2)) || direction.equals(DIR.get(4))) {
			// 加入除了当前方向的左右两边60°前进方向
			if (reachable(node, node.x + left_60.x, node.y + left_60.y)) {
				neighbors.add(new Node(node.x + left_60.x, node.y + left_60.y));
			}
			if (reachable(node, node.x + righ_60.x, node.y + righ_60.y)) {
				neighbors.add(new Node(node.x + righ_60.x, node.y + righ_60.y));
			}
		}
	}

	/**
	 * 获取这个点附近的所有节点
	 * 做了一个取巧的方法，起点加入的时候判断一下起点和终点的方向，我们优先遍历起点->终点的那几个方向，再遍历其他方向，加快寻路
	 */
	private void getNeighborsAll(Node node, Node end) {
		neighbors.clear();

		// 有前节点的时候，忽略劣质节点
		// 0:X同方向 1:下面 -1:上面
		int dx = 0;
		// 当前节点在父节点的下方
		if (end.x > node.x) {
			dx = 1;
		}
		// 当前节点在父节点的上方
		else if (end.x < node.x) {
			dx = -1;
		}

		// 0:Y同放下 1:右边 -1:左边
		int dy = 0;
		// 当前节点在父节点的右边
		if (end.y > node.y) {
			dy = 1;
		}
		// 当前节点在父节点的左边
		else if (end.y < node.y) {
			dy = -1;
		}

		if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
			dy = 0;
		}

		// 计算当前的方向，
		int index = DIR.indexOf(new Node(dx, dy));
		// 从当前方向开始遍历
		for (int i = 0; i < DIR.size(); i++) {
			index = index % DIR.size();
			Node direction = DIR.get(index);
			if (reachable(node, node.x + direction.x, node.y + direction.y)) {
				neighbors.add(new Node(node.x + direction.x, node.y + direction.y));
			}
			index++;
		}
	}

	/**
	 * 判断当前点是否可以通过
	 *
	 * @return true:可以通过 false:不可以通过
	 */
	public boolean reachable(Node from, int x, int y) {
		if (!isWalkableAt(from, x, y))
			return false;
		// 横、纵
		if (from.x == x || from.y == y)
			return true;
		// 避免斜线穿墙
		return isWalkableAt(from, x, from.y) || isWalkableAt(from, from.x, y);
	}

	private void calcF(Node curr, Node end) {
		curr.f = curr.g + getHeuristic(end.x - curr.x, end.y - curr.y);
	}



}
