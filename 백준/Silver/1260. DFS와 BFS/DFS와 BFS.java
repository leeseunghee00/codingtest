import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(V);
		System.out.println();

		for (int i = 0; i <= N; i++) {
			visited[i] = false;
		}

		bfs(V);
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int i : graph.get(v)) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(v);
		visited[v] = true;

		while (!queue.isEmpty()) {

			int num = queue.poll();
			System.out.print(num + " ");

			for (int i : graph.get(num)) {
				if (!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
