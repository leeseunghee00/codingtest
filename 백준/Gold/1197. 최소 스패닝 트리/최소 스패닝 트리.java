import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, cnt, result;
	static List<List<Vertex>> adjList = new ArrayList<>();
	static boolean[] visited;
	static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}

		visited = new boolean[V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());

			adjList.get(A).add(new Vertex(B, C));
			adjList.get(B).add(new Vertex(A, C));
		}

		// 프림 알고리즘
		visited[0] = true;

		for (Vertex vertex : adjList.get(0)) {
			pqueue.offer(vertex);
		}

		while (!pqueue.isEmpty()) {
			Vertex vertex = pqueue.poll();

			if (visited[vertex.v]) {
				continue;
			}

			visited[vertex.v] = true;
			result += vertex.c;
			cnt++;

			if (cnt == V - 1) {
				break;
			}

			for (Vertex next : adjList.get(vertex.v)) {
				if (!visited[next.v]) {
					pqueue.offer(next);
				}
			}
		}

		System.out.println(result);
	}

	static class Vertex {
		int v;
		int c;

		public Vertex(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
