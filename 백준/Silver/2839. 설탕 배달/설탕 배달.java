import java.util.Scanner;

public class Main {

	static int[] dp = new int[5001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N >= 3) {
			dp[3] = 1;
		}

		if (N >= 5) {
			dp[5] = 1;
		}

		for (int i = 6; i <= N; i++) {
			if (i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			} else if (i % 3 == 0) {
				dp[i] = dp[i - 3] + 1;
			} else if (dp[i - 3] != 0 && dp[i - 5] != 0) {
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			}
		}

		if (dp[N] == 0) {
			System.out.println("-1");
		} else {
			System.out.println(dp[N]);
		}
	}
}
