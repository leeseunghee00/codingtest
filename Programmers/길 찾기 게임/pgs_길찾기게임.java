import java.util.Arrays;
import java.util.Comparator;

class Node {

	int value;
	int x;
	int y;
	Node right;
	Node left;

	Node (int value, int x, int y, Node right, Node left) {
		this.value = value;
		this.x = x;
		this.y = y;
		this.right = right;
		this.left = left;
	}
}

public class pgs_길찾기게임 {

	static int[][] result;
	static int idx = 0;

	public static void main(String[] args) {

		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

		System.out.println(solution(nodeinfo));
	}

	private static int[][] solution(int[][] nodeinfo) {

		Node[] node = new Node[nodeinfo.length];

		for (int i = 0; i < nodeinfo.length; i++) {
			node[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
		}

		// y -> 오름차순, x -> 내림차순
		Arrays.sort(node, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if (a.y == b.y) {
					return a.x - b.x;
				}
				return b.y - a.y;
			}
		});

		// 트리 만들기
		Node parent = node[0];

		for (int i = 1; i < node.length; i++) {
			makeTree(parent, node[i]);
		}

		result = new int[2][nodeinfo.length];

		preorder(parent);
		idx = 0;
		postorder(parent);

		return result;
	}

	private static void makeTree(Node parent, Node child) {

		if (parent.x < child.x) {
			if (parent.right == null) {
				parent.right = child;
			} else {
				makeTree(parent.right, child);
			}
		} else {
			if (parent.left == null) {
				parent.left = child;
			} else {
				makeTree(parent.left, child);
			}
		}
	}

	// 전위순회 (가 -> 왼 -> 오)
	private static void preorder(Node root) {
		if (root != null) {
			result[0][idx++] = root.value;
			preorder(root.left);
			preorder(root.right);
		}
	}

	// 후위순회 (왼 -> 오 -> 가)
	private static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			result[1][idx++] = root.value;
		}
	}
}
