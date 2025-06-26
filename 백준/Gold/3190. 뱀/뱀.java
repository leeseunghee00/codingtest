import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위치별 값 의미
 * - 0: 사과 없음 & 뱀 몸통 아님
 * - 1: 사과 있음
 * - 2: 뱀 몸통 위치
 */
public class Main {

	static int n, k, l, result;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int[] dx = {0, 1, 0, -1}; // 상, 우, 하, 좌

	static Deque<Pos> snake = new ArrayDeque<>();
	static Queue<Command> commands = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			// 사과 위치 표시
			map[y][x] = 1;
		}

		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);

			commands.offer(new Command(time, dir));
		}


		result = simulate();

		System.out.println(result);
	}

	private static int simulate() {
		int time = 0;
		int dir = 1;	// 초기 방향: 오른쪽

		Pos pos = new Pos(0, 0);
		snake.offerFirst(pos);
		map[0][0] = 2;

		while (true) {
			time++;

			Pos head = snake.peekFirst();
			int ny = head.y + dy[dir];
			int nx = head.x + dx[dir];

			// 벽 또는 자기 자신과 부딪히면 종료
			if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] == 2) {
				return time;
			}

			// 사과가 없다면 꼬리 줄이기
			if (map[ny][nx] != 1) {
				Pos tail = snake.pollLast();
				map[tail.y][tail.x] = 0;
			}

			// 머리 이동
			snake.offerFirst(new Pos(ny, nx));
			map[ny][nx] = 2;

			// 방향 전환
			if (!commands.isEmpty() && commands.peek().time == time) {
				Command command = commands.poll();
				if (command.dir == 'L') {
					dir = (dir + 3) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
			}
		}
	}

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Command {
		int time;
		char dir;

		public Command(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}
}
