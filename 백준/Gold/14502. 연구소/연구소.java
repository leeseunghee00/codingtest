import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int zeroSize;

	static int[][] map, copyMap;
	static List<Location> zero = new ArrayList<>();
	static List<Location> virus = new ArrayList<>();
	static Location[] walls = new Location[3];
	static Queue<Location> queue = new ArrayDeque<>();

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyMap = new int[N][M];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					zero.add(new Location(i, j));
				} else if (map[i][j] == 2) {
					virus.add(new Location(i, j));
				}
			}
		}

		zeroSize = zero.size();
		combination(0, 0);

		System.out.println(max);
	}

	private static void combination(int src, int tgt) {
		if (tgt == 3) {
			check();
			return;
		}

		if (src == zeroSize) {
			return;
		}

		walls[tgt] = zero.get(src);

		combination(src + 1, tgt + 1);
		combination(src + 1, tgt);

	}

	private static void check() {
		// 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		// 임의벽 세우기
		for (Location wall : walls) {
			copyMap[wall.y][wall.x] = 1;
		}

		// 바이러스 전파
		queue.addAll(virus);

		while (!queue.isEmpty()) {
			Location loc = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + loc.y;
				int nx = dx[i] + loc.x;

				if (ny >= N || nx >= M || ny < 0 || nx < 0) {
					continue;
				}

				if (copyMap[ny][nx] == 0) {
					copyMap[ny][nx] = 2;
					queue.offer(new Location(ny, nx));
				}
			}
		}

		// 0 갯수 카운트
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					count++;
				}
			}
		}

		max = Math.max(count, max);
	}

	static class Location {
		int y, x;

		public Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
