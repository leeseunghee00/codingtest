import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M;
	static int[][] dp = new int[31][31];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			System.out.println(combination(M, N));
		}
	}

	private static int combination(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		}

		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		return dp[n][r] = combination(n - 1 , r - 1) + combination(n - 1, r);
	}
}
