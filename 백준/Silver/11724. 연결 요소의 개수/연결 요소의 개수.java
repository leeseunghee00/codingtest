import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N, M, count;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
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

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

	private static void dfs(int v) {
		visit[v] = true;

		for (int i : graph.get(v)) {
			if (!visit[i]) {
				dfs(i);
			}
		}
	}
}
