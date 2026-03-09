import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[][] map;
	static boolean[][] visited;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int height = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(map[i][j], height);
			}
		}

		max = 1;		// 아무 지역도 침수되지 않았을 경우

		for (int rain = 0; rain <= height; rain++) {
			visited = new boolean[N][N];
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > rain) {
						dfs(i, j, rain);
						count++;
					}
				}
			}

			max = Math.max(max, count);
		}

		System.out.println(max);
	}

	private static void dfs(int y, int x, int rain) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) {
				continue;
			}

			if (map[ny][nx] > rain) {
				dfs(ny, nx, rain);
			}
		}
	}
}
