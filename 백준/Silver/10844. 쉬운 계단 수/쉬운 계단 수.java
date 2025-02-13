import java.util.Scanner;

public class Main {

	static int N;
	static long result;
	static long[][] dp;
	static final long MOD = 10_0000_0000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new long[N + 1][10];	// r: 자릿수, c: 자릿값

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % MOD;
				} else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % MOD;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
		}

		System.out.println(result % MOD);
	}
}
