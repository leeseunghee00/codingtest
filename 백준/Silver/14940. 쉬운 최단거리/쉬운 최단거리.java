import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr, result;
	static boolean[][] visited;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		result = new int[n][m];
		visited = new boolean[n][m];

		int startY = -1, startX = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 2) {
					startY = i;
					startX = j;
				}
			}
		}

		bfs(startY, startX);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					System.out.print("0 ");
				} else if (!visited[i][j]) {
					System.out.print("-1 ");
				} else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void bfs(int startY, int startX) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startY, startX});
		visited[startY][startX] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int y = curr[0];
			int x = curr[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m
					|| visited[ny][nx] || arr[ny][nx] == 0) {
					continue;
				}

				result[ny][nx] = result[y][x] + 1;
				visited[ny][nx] = true;
				queue.offer(new int[]{ny, nx});
			}

		}
	}
}
