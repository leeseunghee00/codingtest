import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] T, P, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N; i >= 1; i--) {
			// 근무를 할 수 있는 경우
			if (N >= i + T[i] - 1) {
				dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
			} else {
				// 근무를 할 수 없는 경우
				dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[1]);
	}
}
