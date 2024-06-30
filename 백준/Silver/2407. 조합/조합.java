import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		BigInteger[][] dp = new BigInteger[101][101];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = BigInteger.ONE;
				} else {
					dp[i][j] = dp[i - 1][j].add(dp[i - 1][j - 1]);
				}
			}
		}

		System.out.println(dp[N][M]);
	}
}
