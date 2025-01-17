import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, A, B, M, result = -1;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
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

		for (int i = 0; i < M; i++) {
			Collections.sort(graph.get(i));
		}

		chonsuCalc(A, 0);

		System.out.println(result);
	}

	private static void chonsuCalc(int num, int distance) {

		if (num == B) {
			result = distance;
			return;
		}

		visited[num] = true;

		for (int next : graph.get(num)) {
			if (!visited[next]) {
				chonsuCalc(next, distance + 1);

				if (result != -1) {
					return;
				}
			}
		}
	}
}
