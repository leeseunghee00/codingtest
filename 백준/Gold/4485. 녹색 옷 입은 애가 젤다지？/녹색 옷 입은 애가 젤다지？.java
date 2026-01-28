import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] dist;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			arr = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			int result = dijkstra();

			System.out.println("Problem " + T + ": " + result);
			T++;
		}
	}

	private static int dijkstra() {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((a, b) -> {return a.cost - b.cost;});
		dist[0][0] = arr[0][0];
		pqueue.add(new Node(0, 0, dist[0][0]));

		while (!pqueue.isEmpty()) {
			Node curr = pqueue.poll();

			if (curr.cost != dist[curr.y][curr.x]) {
				continue;
			}

			if (curr.y == N - 1 && curr.x == N - 1) {
				return curr.cost;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + curr.y;
				int nx = dx[i] + curr.x;

				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					continue;
				}

				int ncost = curr.cost + arr[ny][nx];

				if (ncost < dist[ny][nx]) {
					dist[ny][nx] = ncost;
					pqueue.add(new Node(ny, nx, ncost));
				}
			}
		}

		return dist[N - 1][N - 1];
	}

	static class Node {
		int y, x, cost;

		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
}
