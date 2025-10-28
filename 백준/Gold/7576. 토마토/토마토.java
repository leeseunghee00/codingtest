import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, count;
	static int[][] tomatoes;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomatoes = new int[N][M];

		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());

				if (tomatoes[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}

		// 익었는지 확인
		if (isRipe()) {
			System.out.println(0);
			return;
		}

		bfs(queue);

		// bfs 이후 익었는지 확인
		if (!isRipe()) {
			System.out.println(-1);
			return;
		}

		System.out.println(count);
	}

	private static boolean isRipe() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoes[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	private static void bfs(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();
				int r = curr[0], c = curr[1];

				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						continue;
					}

					if (tomatoes[nr][nc] == 0) {
						tomatoes[nr][nc] = 1;
						queue.add(new int[]{nr, nc});
					}
				}
			}

			if (!queue.isEmpty()) {
				count++;
			}
		}
	}
}
