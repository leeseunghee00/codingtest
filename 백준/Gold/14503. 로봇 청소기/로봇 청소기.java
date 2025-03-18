import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, C, D, result;
	static int[][] room;
	static int[] dr = {-1, 0, 1, 0}; // 0: 북, 1: 동, 2: 남, 3: 서
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cleaning(R, C, D);
		System.out.println(result);
	}

	private static void cleaning(int r, int c, int d) {
		// 현재 위치가 청소되지 않았다면 청소
		if (room[r][c] == 0) {
			room[r][c] = 2;
			result++;
		}

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] == 0) {
				cleaning(nr, nc, d);
				return;
			}
		}

		// 4방향 모두 청소되어 있다면 후진
		int backD = (d + 2) % 4;
		int nr = r + dr[backD];
		int nc = c + dc[backD];

		// 후진이 가능하면 후진, 벽이면 종료
		if (nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] != 1) {
			cleaning(nr, nc, d);
		}
	}
}
