import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, time;
	static int[][] arr;

	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int lastCount = 0;

		while (true) {
			int cheeseCount = countCheese();

			if (cheeseCount == 0) {
				break;
			}

			lastCount = cheeseCount;

			bfs();

			time++;
		}

		System.out.println(time);
		System.out.println(lastCount);
	}

	private static int countCheese() {
		int count = 0;
		
		// 남은 치즈 갯수 카운트
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 1) {
					count++;
				}
			}
		}

		return count;
	}

	private static void bfs() {
		Queue<Cheeses> queue = new LinkedList<>();
		queue.offer(new Cheeses(0, 0));
		visited = new boolean[R][C];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Cheeses cheeses = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cheeses.r + dr[i];
				int nc = cheeses.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) {
					continue;
				}

				// 가장자리 치즈 -> 0 으로 변경 (녹음)
				if (arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
				} else { 
					// 빈 공간 0 일 경우 -> 큐 채움
					queue.offer(new Cheeses(nr, nc));
				}

				visited[nr][nc] = true;
			}
		}
	}

	static class Cheeses {
		int r;
		int c;

		public Cheeses(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
