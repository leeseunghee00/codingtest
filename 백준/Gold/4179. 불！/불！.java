import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 1000;

	static int R, C;
	static char[][] miro;
	static int[][] jhDist, fireDist;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		miro = new char[R][C];
		jhDist = new int[R][C];
		fireDist = new int[R][C];

		for (int i = 0; i < R; i++) {
			Arrays.fill(jhDist[i], -1);
			Arrays.fill(fireDist[i], INF);
		}

		Queue<int[]> jhQueue = new ArrayDeque<>();
		Queue<int[]> fireQueue = new ArrayDeque<>();

		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				char ch = line.charAt(c);
				miro[r][c] = ch;

				if (ch == 'F') {
					fireDist[r][c] = 0;
					fireQueue.add(new int[] {r, c});
				} else if (ch == 'J') {
					jhDist[r][c] = 0;
					jhQueue.add(new int[] {r, c});
				}
			}
		}

		// 불 이동
		while (!fireQueue.isEmpty()) {
			int[] curr = fireQueue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || miro[nr][nc] == '#') {
					continue;
				}

				if (fireDist[nr][nc] > fireDist[curr[0]][curr[1]] + 1) {
					fireDist[nr][nc] = fireDist[curr[0]][curr[1]] + 1;
					fireQueue.add(new int[]{nr, nc});
				}
			}
		}

		// 지훈 이동
		while (!jhQueue.isEmpty()) {
			int[] curr = jhQueue.poll();

			// 다음 걸음이 탈출일 경우
			if (curr[0] == 0 || curr[1] == 0 || curr[0] == R - 1 || curr[1] == C - 1) {
				System.out.println(jhDist[curr[0]][curr[1]] + 1);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || miro[nr][nc] == '#' || jhDist[nr][nc] != -1) {
					continue;
				}

				// 불이 다음 위치에 올 경우 -> 못 감
				if (fireDist[nr][nc] <= jhDist[curr[0]][curr[1]] + 1) {
					continue;
				}

				jhDist[nr][nc] = jhDist[curr[0]][curr[1]] + 1;
				jhQueue.add(new int[]{nr, nc});
			}
		}

		System.out.println("IMPOSSIBLE");
	}
}
