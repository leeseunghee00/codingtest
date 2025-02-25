import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, result;
	static char[][] arr;
	static boolean[][] visited;

	static int[] dr = {-1, 0, 1};	// 오른쪽 위, 오른쪽, 오른쪽 아래
	static int[] dc = {1, 1, 1};	// 오른쪽 위, 오른쪽, 오른쪽 아래

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				arr[i][j] = line.charAt(j);
			}
		}


		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				result++;
			}
		};

		System.out.println(result);
	}

	private static boolean dfs(int r, int c) {

		if (c == C - 1) {
			return true;
		}

		visited[r][c] = true;

		for (int i = 0; i < 3; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc] || arr[nr][nc] == 'x') {
				continue;
			}

			if (dfs(nr, nc)) {
				return true;
			};
		}

		return false;
	}
}
