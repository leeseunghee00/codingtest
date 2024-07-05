import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static int[][] arr;
	static int[][][] dp;	// 0: 가로, 1: 세로, 2: 대각선

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				// 벽이 있을 경우
				if (arr[i][j] == 1) {
					continue;
				}

				// 가로 방향
				if (j - 1 >= 0 && arr[i][j - 1] == 0) {
					dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
				}

				// 세로 방향
				if (i - 1 >= 0 && arr[i - 1][j] == 0) {
					dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
				}

				// 대각선 방향
				if (i - 1 >= 0 && j - 1 >= 0 && arr[i- 1][j] == 0
					&& arr[i][j - 1] == 0 && arr[i - 1][j - 1] == 0
				) {
					dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
		System.out.println(result);
	}
}
