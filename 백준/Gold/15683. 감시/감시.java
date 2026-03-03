import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[][] office;
	static List<CCTV> cctvList = new ArrayList<>();

	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// 타입별 상하좌우 회전
	static int[][][] directions = {
		{},
		{{0}, {1}, {2}, {3}},
		{{0, 1}, {2, 3}},
		{{0, 3}, {0, 2}, {1, 2}, {1, 3}},
		{{0, 2, 3}, {0, 1, 2}, {1, 2, 3}, {0, 1, 3}},
		{{0, 1, 2, 3}}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());

				if (office[i][j] >= 1 && office[i][j] <= 5) {
					cctvList.add(new CCTV(i, j, office[i][j]));
				}
			}
		}

		result = Integer.MAX_VALUE;
		dfs(0);

		System.out.println(result);
	}

	/* 시뮬레이션 */
	private static void dfs(int depth) {
		if (depth == cctvList.size()) {
			countSpot();
			return;
		}

		CCTV cctv = cctvList.get(depth);
		int type = cctv.type;

		for (int[] dir : directions[type]) {
			List<int[]> changed = new ArrayList<>();

			for (int d : dir) {
				changed.addAll(watch(cctv.r, cctv.c, d));
			}

			dfs(depth + 1);
			undo(changed);
		}
	}

	/* 감시 */
	private static List<int[]> watch(int r, int c, int d) {
		List<int[]> changed = new ArrayList<>();

		int nr = r;
		int nc = c;

		while (true) {
			nr += dr[d];
			nc += dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || office[nr][nc] == 6) {
				break;
			}

			if (office[nr][nc] == 0) {
				office[nr][nc] = -1;
				changed.add(new int[]{nr, nc});
			}
		}

		return changed;
	}

	/* 감시 되돌리기 */
	private static void undo(List<int[]> changed) {
		for (int[] pos : changed) {
			office[pos[0]][pos[1]] = 0;
		}
	}

	/* 빈 공간 세기 */
	private static void countSpot() {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0) {
					count++;
				}
			}
		}

		result = Math.min(result, count);
	}

	static class CCTV {
		int r, c, type;

		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
}