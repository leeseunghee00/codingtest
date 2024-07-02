import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt, mstCost, maxCost;
	static int[] parent;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(A, B, C);
		}

		// 크루스칼 알고리즘
		Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

		makeSet();

		for (Edge edge : edges) {
			if (union(edge.v, edge.w)) {
				mstCost += edge.c;
				maxCost = edge.c;
				cnt++;

				if (cnt == N - 1) {
					break;
				}
			}
		}

		System.out.println(mstCost - maxCost);
	}

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		return (parent[x] == x) ? x : (parent[x] = findSet(parent[x]));
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py) {		// 두 부모가 같다 → 사이클 발생
			return false;
		}

		parent[py] = px;
		return true;
	}

	static class Edge{
		int v, w, c;

		public Edge(int v, int w, int c) {
			this.v = v;
			this.w = w;
			this.c = c;
		}
	}
}
