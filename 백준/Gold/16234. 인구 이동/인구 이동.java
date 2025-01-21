import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R, result;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Node> queue = new LinkedList<>();
	static List<Node> union;

	// 상하좌우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[N][N];
			boolean isMoved = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j)) {
							isMoved = true;
						}
					}
				}
			}

			if (!isMoved) {
				break;
			}

			result++;
		}

		System.out.println(result);
	}

	private static boolean bfs(int r, int c) {
		queue.offer(new Node(r, c));
		visited[r][c] = true;

		union = new ArrayList<>();
		union.add(new Node(r, c));

		int totalPeople = arr[r][c];
		int totalCountries =  1;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = node.r + dy[i];
				int nx = node.c + dx[i];

				if (ny < 0 || ny >= N || nx <0 || nx >= N || visited[ny][nx]) {
					continue;
				}

				int diff = Math.abs(arr[node.r][node.c] - arr[ny][nx]);

				if (L <= diff && diff <= R) {
					visited[ny][nx] = true;
					queue.offer(new Node(ny, nx));
					union.add(new Node(ny, nx));

					totalPeople += arr[ny][nx];
					totalCountries++;
				}
			}
		}

		if (totalCountries > 1) {
			int newPopulation = totalPeople / totalCountries;

			for (Node node : union) {
				arr[node.r][node.c] = newPopulation;
			}

			return true;
		}

		return false;

	}

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
