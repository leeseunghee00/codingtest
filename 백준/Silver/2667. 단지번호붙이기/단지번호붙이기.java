import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] graph;
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new char[N][];

		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == '1') {
					int dCnt = dfs(i, j);
					result.add(dCnt);
				}
			}
		}

		System.out.println(result.size());
		Collections.sort(result);
		for (int i : result) {
			System.out.println(i);
		}
	}

	private static int dfs(int y, int x) {
		graph[y][x] = '0';
		int count = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && nx >= 0 && ny < N && nx < N && graph[ny][nx] == '1') {
				count += dfs(ny, nx);
			}
		}

		return count;
	}
}
