import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int[] kbCount;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		kbCount = new int[N + 1];

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

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result = Integer.MAX_VALUE;
				Arrays.fill(visited, false);

				if (i != j) {
					dfs(i, j, 0);
					kbCount[i] += result;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 1; i <= N; i++) {
			if (min > kbCount[i]) {
				min = kbCount[i];
				idx = i;
			}
		}

		System.out.println(idx);
	}

	private static void dfs(int start, int end, int count) {

		if (start == end) {
			result = Math.min(result, count);
			return;
		}

		visited[start] = true;

		for (int next : graph.get(start)) {
			if (!visited[next]) {
				dfs(next, end, count + 1);
			}
		}
	}
}
