import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 10001;

	static int n, k;
	static int[] coins, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		coins = new int[n + 1];
		dp = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int coin : coins) {
			for (int i = coin; i <= k; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		if (dp[k] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}