import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[][] map = new boolean[101][101];

	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			simulation(x, y, d, g);
		}

		int result = getCurveCount();

		System.out.println(result);
	}

	/* 시뮬레이션 */
	private static void simulation(int x, int y, int d, int g) {
		List<Integer> dirs = new ArrayList<>();
		dirs.add(d);

		for (int i = 0; i < g; i++) {
			for (int j = dirs.size() - 1; j >= 0; j--) {
				dirs.add((dirs.get(j) + 1) % 4);
			}
		}

		map[y][x] = true;

		for (int dir : dirs) {
			x += dx[dir];
			y += dy[dir];
			map[y][x] = true;
		}
	}

	/* 커브 갯수 */
	private static int getCurveCount() {
		int count = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					count++;
				}
			}
		}

		return count;
	}
}
