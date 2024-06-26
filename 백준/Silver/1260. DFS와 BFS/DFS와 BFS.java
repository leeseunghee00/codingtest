import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, V;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		visit = new boolean[N + 1];
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(V);

		for (int i = 0; i <= N; i++) {
			visit[i] = false;
		}

		System.out.println();

		bfs(V);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(v);
		visit[v] = true;

		while (!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num + " ");

			for (int i : graph.get(num)) {
				if (!visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}

	private static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");

		for (int i : graph.get(v)) {
			if (!visit[i]) {
				dfs(i);
			}
		}
	}

}
