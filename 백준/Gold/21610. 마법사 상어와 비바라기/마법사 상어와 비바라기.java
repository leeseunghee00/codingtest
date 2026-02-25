import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;

	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	static List<int[]> clouds = new ArrayList<>();
	static boolean[][] wasCloud;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 구름
		clouds.add(new int[]{N - 1, 1});
		clouds.add(new int[]{N - 1, 2});
		clouds.add(new int[]{N, 1});
		clouds.add(new int[]{N, 2});

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			move(d, s);
			checkDiagonal();
			saveCloud();
			clouds.clear();
			make();
		}

		int sum = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	private static void move(int d, int s) {

		for (int i = 0; i < clouds.size(); i++) {
			int r = clouds.get(i)[0];
			int c = clouds.get(i)[1];

			r = ((r - 1 + dr[d] * s) % N + N) % N + 1;
			c = ((c - 1 + dc[d] * s) % N + N) % N + 1;

			clouds.get(i)[0] = r;
			clouds.get(i)[1] = c;

			map[r][c] += 1;
		}
	}

	private static void checkDiagonal() {

		int[][] copy = new int[N + 1][N + 1];

		for (int[] cloud : clouds) {
			int r = cloud[0];
			int c = cloud[1];
			int count = 0;

			for (int j = 2; j <= 8; j += 2) {
				int nr = r + dr[j];
				int nc = c + dc[j];

				if (nr <= 0 || nr > N || nc <= 0 || nc > N) {
					continue;
				}

				if (map[nr][nc] > 0) {
					count++;
				}
			}

			copy[r][c] = count;
		}

		for (int[] cloud : clouds) {
			int r = cloud[0];
			int c = cloud[1];
			map[r][c] += copy[r][c];
		}
	}

	private static void saveCloud() {

		wasCloud = new boolean[N + 1][N + 1];

		for (int[] c : clouds) {
			wasCloud[c[0]][c[1]] = true;
		}
	}

	private static void make() {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] >= 2 && !wasCloud[i][j]) {
					clouds.add(new int[]{i, j});
					map[i][j] -= 2;
				}
			}
		}
	}
}