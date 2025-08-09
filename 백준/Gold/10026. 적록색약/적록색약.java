import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static char[][] arr;
	static boolean[][] visited;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 일반 시야
		visited = new boolean[N][N];
		int normalCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, false);
					normalCount++;
				}
			}
		}

		// 적록색약
		visited = new boolean[N][N];
		int blindnessCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, true);
					blindnessCount++;
				}
			}
		}

		System.out.println(normalCount + " " + blindnessCount);
	}

	private static void bfs(int r, int c, boolean flag) {    // flag: 적록색약 플래그
		Queue<int[]> queue = new LinkedList<>();
		char color = arr[r][c];
		visited[r][c] = true;
		queue.offer(new int[] {r, c});

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int colorR = now[0], colorC = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = colorR + dr[i];
				int nc = colorC + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
					continue;
				}

				if (isSameColor(color, arr[nr][nc], flag)) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}

			}
		}
	}

	private static boolean isSameColor(char c1, char c2, boolean flag) {
		// 적록색약이면 -> R,G 같은 취급
		if (flag) {
			if ((c1 == 'R' || c1 == 'G') && (c2 == 'G' || c2 == 'R')) {
				return true;
			}
		}

		// 일반이면 -> R,G,B 구분
		return c1 == c2;
	}
}
