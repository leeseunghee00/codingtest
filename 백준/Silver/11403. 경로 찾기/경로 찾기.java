import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr, result;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {
					graph.get(i).add(j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			navigation(i, i, visited);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void navigation(int idx, int newIdx, boolean[] visited) {

		 if (graph.get(newIdx).isEmpty()) {
			 return;
		 }

		for (int num : graph.get(newIdx)) {
			if (!visited[num]) {
				result[idx][num] = 1;
				visited[num] = true;
				navigation(idx, num, visited);
			}
		}
	}
}
