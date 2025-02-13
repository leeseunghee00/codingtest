import java.util.Scanner;

public class Main {

	static int t, k, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		int[][] dp = new int[15][15];
		for (int i = 1; i < 15; i++) {	// 0층 초기화
			dp[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {	// 1~14층 초기화
			for (int j = 1; j < 15; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		while (t-- > 0) {
			k = sc.nextInt();
			n = sc.nextInt();

			System.out.println(dp[k][n]);
		}
	}
}
