import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[][] space, dp;

	static int[] dy = {1, 1, 1};
	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		space = new int[N][M];
		dp = new int[N][M];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				dfs(0, i, j, space[0][i]);
			}
		}

		System.out.println(result);
	}

	private static void dfs(int y, int x, int d, int sum) {

		if (y == N - 1) {
			result = Math.min(sum, result);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (d == i) {
				continue;
			}

			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
				continue;
			}

			dfs(ny, nx, i, space[ny][nx] + sum);
		}
	}
}
