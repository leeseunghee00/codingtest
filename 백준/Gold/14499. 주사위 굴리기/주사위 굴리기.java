import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, x, y, K;

	// 동, 서, 남, 북
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};

	static int[][] map;

	// dice[0] : 위
	// dice[1] : 서
	// dice[2] : 북
	// dice[3] : 동
	// dice[4] : 남
	// dice[6] : 아래
	static int[] dice = new int[7];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			move(Integer.parseInt(st.nextToken()));
		}
	}

	private static void move(int k) {
		if (k == 1) {
			east();
		}
		else if (k == 2) {
			west();
		}
		else if (k == 3) {
			north();
		}
		else if (k == 4) {
			south();
		}
	}

	private static void east() {
		int ny = y + dy[0];
		int nx = x + dx[0];

		if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
			return;
		}

		int temp = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[6];
		dice[6] = dice[3];
		dice[3] = temp;

		y = ny;
		x = nx;

		print();
	}

	private static void west() {
		int ny = y + dy[1];
		int nx = x + dx[1];

		if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
			return;
		}

		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[1];
		dice[1] = temp;

		y = ny;
		x = nx;

		print();
	}

	private static void north() {
		int ny = y + dy[3];
		int nx = x + dx[3];

		if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
			return;
		}

		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[4];
		dice[4] = temp;

		y = ny;
		x = nx;

		print();
	}

	private static void south() {
		int ny = y + dy[2];
		int nx = x + dx[2];

		if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
			return;
		}

		int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[2];
		dice[2] = temp;

		y = ny;
		x = nx;

		print();
	}

	private static void print() {
		if (map[y][x] == 0) {
			map[y][x] = dice[6];
		} else {
			dice[6] = map[y][x];
			map[y][x] = 0;
		}
		System.out.println(dice[0]);
	}
}
