import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int rY, rX, bY, bX;

	static char[][] map;
	static boolean[][][][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m][n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j =0; j < m; j++) {
				if (map[i][j] == 'R') {
					rY = i;
					rX = j;
				} else if (map[i][j] == 'B') {
					bY = i;
					bX = j;
				}
			}
		}

		int result = move();

		System.out.println(result);
	}

	private static int move() {
		Queue<Ball> queue = new LinkedList<>();

		queue.offer(new Ball(rY, rX, bY, bX, 0));
		visited[rY][rX][bY][bX] = true;

		while (!queue.isEmpty()) {
			Ball curr = queue.poll();

			if (curr.depth >= 10) {
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int[] red = roll(curr.ry, curr.rx, d);
				int[] blue = roll(curr.by, curr.bx, d);

				// 파란 구슬이 구멍에 빠지면 -> 실패
				if (map[blue[0]][blue[1]] == 'O') {
					continue;
				}

				// 빨간 구슬이 구멍에 빠지면 -> 성공
				if (map[red[0]][red[1]] == 'O') {
					return curr.depth + 1;
				}

				// 파란 구슬과 빨간 구슬이 겹칠 경우 -> 위치 조정
				if (red[0] == blue[0] && red[1] == blue[1]) {
					if (red[2] > blue[2]) { // red 가 blue 보다 늦게 도착했을 경우 -> 한칸 뒤로 이동
						red[0] -= dy[d];
						red[1] -= dx[d];
					} else {
						blue[0] -= dy[d];
						blue[1] -= dx[d];
					}
				}

				if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
					visited[red[0]][red[1]][blue[0]][blue[1]] = true;
					queue.offer(new Ball(red[0], red[1], blue[0], blue[1], curr.depth + 1));
				}
			}
		}

		return -1;
	}

	private static int[] roll(int y, int x, int d) {
		int dist = 0;

		while (map[y + dy[d]][x + dx[d]] != '#' && map[y][x] != 'O') {
			y += dy[d];
			x += dx[d];
			dist++;
		}

		return new int[]{y, x, dist};
	}


	static class Ball {
		int ry;
		int rx;
		int by;
		int bx;
		int depth;

		public Ball(int ry, int rx, int by, int bx, int depth) {
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.depth = depth;
		}
	}
}
