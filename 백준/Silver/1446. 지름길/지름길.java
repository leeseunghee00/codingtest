import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, D;
	static int[] dp;
	static List<Node> shortcuts = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			if (end > D) {
				continue;
			}

			if (end - start <= length) {
				continue;
			}

			shortcuts.add(new Node(start, end, length));
		}

		dp = new int[D + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i <=D; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			}

			for (Node sc : shortcuts) {
				if (sc.start == i) {
					dp[sc.end] = Math.min(dp[sc.end], dp[i] + sc.length);
				}
			}
		}

		System.out.println(dp[D]);
	}

	static class Node {
		int start, end, length;

		public Node(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}
}
