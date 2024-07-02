import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X;
	static List<List<Node>> map = new ArrayList<>();
	static List<List<Node>> reverseMap = new ArrayList<>();
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
			reverseMap.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			map.get(v).add(new Node(w, t));
			reverseMap.get(w).add(new Node(v, t));
		}

		int[] toX = dijkstra(map);
		int[] fromX = dijkstra(reverseMap);


		// 최대시간 찾기
		int maxTime = 0;

		for (int i = 1; i <= N; i++) {
			maxTime = Math.max(toX[i] + fromX[i], maxTime);
		}

		System.out.println(maxTime);
	}

	private static int[] dijkstra(List<List<Node>> list) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.t - n2.t);

		int[] time = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(time, INF);

		time[X] = 0;
		pqueue.offer(new Node(X, 0));

		while (!pqueue.isEmpty()) {
			Node node = pqueue.poll();

			if (visited[node.w]) {
				continue;
			}

			visited[node.w] = true;

			for (Node curNode : list.get(node.w)) {

				if (visited[curNode.w]) {
					continue;
				}

				if (time[curNode.w] > time[node.w] + curNode.t) {
					time[curNode.w] = time[node.w] + curNode.t;
					pqueue.offer(new Node(curNode.w, time[curNode.w]));
				}
			}
		}

		return time;
	}

	static class Node{
		int w;
		int t;

		public Node(int w, int t) {
			this.w = w;
			this.t = t;
		}
	}
}
