import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int MOD = 1000_000_000;
	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1][N + 1];
		Arrays.fill(dp[1], 1);

		if (K == 1) {
			System.out.println(dp[K][N]);
			return;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
				}
			}
		}

		System.out.println(dp[K][N]);
	}
}
