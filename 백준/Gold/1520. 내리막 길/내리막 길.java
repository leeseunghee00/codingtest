import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static int[][] load;
	static int[][] dp;

	static int[] dy = {0, 1, 0, -1};	// 오른쪽-아래-왼쪽-위
	static int[] dx = {-1, 0, 1, 0};	// 오른쪽-아래-왼쪽-위

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		load = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				load[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		int result = findGoal(0, 0);

		System.out.println(result);
	}

	private static int findGoal(int y, int x) {

		if (y == M - 1 && x == N - 1) {
			return 1;
		}

		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		dp[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
				continue;
			}

			if (load[y][x] > load[ny][nx]) {
				dp[y][x] += findGoal(ny, nx);
			}
		}

		return dp[y][x];
	}
}
