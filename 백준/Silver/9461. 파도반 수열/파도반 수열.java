import java.util.Scanner;

public class Main {

	static int T, N;
	static long[] dp = new long[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		dp[1] = dp[2] = dp[3] = 1;

		for (int j = 4; j < 101; j++) {
			dp[j] = dp[j - 2] + dp[j - 3];
		}

		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			System.out.println(dp[N]);
		}
	}
}
