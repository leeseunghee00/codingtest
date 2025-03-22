import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] miro, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				int maxCandy = 0;

				// 위에서 오는 경우
				if (y > 0) {
					maxCandy = Math.max(maxCandy, dp[y - 1][x]);
				}

				// 왼쪽에서 오는 경우
				if (x > 0) {
					maxCandy = Math.max(maxCandy, dp[y][x - 1]);
				}

				// 대각선 위에서 오는 경우
				if (y > 0 && x > 0) {
					maxCandy = Math.max(maxCandy, dp[y - 1][x - 1]);
				}

				dp[y][x] = miro[y][x] + maxCandy;
			}
		}

		System.out.println(dp[N - 1][M - 1]);
	}
}
