import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[] move = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 사다리 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			move[x] = y;
		}

		// 뱀 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			move[x] = y;
		}

		result = game(1, 0);

		System.out.println(result);
	}

	private static int game(int x, int count) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{x, count});

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int loc = curr[0];
			int cnt = curr[1];


			for (int i = 1; i <= 6; i++) {
				int next = loc + i;

				if (next == 100) {
					return cnt + 1;
				}

				if (move[next] != 0) {
					next = move[next];
				}

				if (!visited[next]) {
					queue.offer(new int[]{next, cnt + 1});
					visited[next] = true;
				}
			}
		}

		return -1;
	}
}

