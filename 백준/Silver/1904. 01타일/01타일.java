import java.util.Scanner;

public class Main {

	static int[] dp = new int[100_0001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dp[1] = 1;
		dp[2] = 2;


		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}

		System.out.println(dp[N]);
	}
}
