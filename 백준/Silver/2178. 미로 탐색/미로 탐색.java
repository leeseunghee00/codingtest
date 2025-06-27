import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static boolean[][] visited;

	static int[] dy = {1, 0, -1, 0};	// 아래-오른쪽-위-왼쪽
	static int[] dx = {0, 1, 0, -1};	// 아래-오른쪽-위-왼쪽

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		System.out.println(arr[n - 1][m - 1]);
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(y, x));
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			if (curr.y == n && curr.x == m) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] || arr[ny][nx] == 0) {
					continue;
				}

				arr[ny][nx] = arr[curr.y][curr.x] + 1;
				visited[ny][nx] = true;
				queue.offer(new Node(ny, nx));
			}
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
