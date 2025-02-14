import java.util.Scanner;

public class Main {

	static int N;
	static long result;
	static long[][] dp = new long[1001][10];
	static final int MOD = 10007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < 10; i++) {	// 첫번째 행 1로 초기화
			dp[1][i] = 1;
		}

		for (int i = 2; i <= 1000; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = (dp[i - 1][j]) % MOD;
					continue;
				}

				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
			}
		}

		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
		}

		result %= MOD;

		System.out.println(result);
	}
}
