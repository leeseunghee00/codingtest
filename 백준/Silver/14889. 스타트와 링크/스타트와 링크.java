import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, result, front, second;
	static int[][] S;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = Integer.MAX_VALUE;

		combination(0, 1);

		System.out.println(result);
	}

	private static void combination(int depth, int start) {

		if (depth == N / 2) {
			result = Math.min(getTeamS(), result);
			return;
		}

		for (int i = start; i <= N; i++) {
			visited[i] = true;
			combination(depth + 1, i + 1);
			visited[i] = false;
		}
	}

	private static int getTeamS() {

		int start = 0;
		int link = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (i == j) {
					continue;
				}

				if (visited[i] && visited[j]) {
					start += S[i][j];
				}

				if (!visited[i] && !visited[j]) {
					link += S[i][j];
				}
			}
		}

		return Math.abs(start - link);
	}
}
