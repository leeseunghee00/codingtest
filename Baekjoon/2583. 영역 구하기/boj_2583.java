import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2583 {

	static int N, M, K;
	static int[][] visited;
	static int[] dx = {0, 0, -1, 1};	// 상하좌우
	static int[] dy = {-1, 1, 0, 0};	// 상하좌우
	static int count = 0;
	static ArrayList<Integer> A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());	// y
		N = Integer.parseInt(st.nextToken());	// x
		K = Integer.parseInt(st.nextToken());

		visited = new int[M][N];
		A = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					visited[y][x] = 1;
				}
			}

		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {
					count = 1;
					dfs(i, j);
					A.add(count);
				}
			}
		}

		Collections.sort(A);

		StringBuilder sb = new StringBuilder();

		sb.append(A.size() + "\n");

		for (int a : A) {
			sb.append(a + " ");
		}

		bw.write(sb + "");
		bw.flush();
		bw.close();
	}

	private static void dfs(int y, int x) {
		visited[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[ny][nx] == 0){
				count++;
				dfs(ny, nx);
			}
		}
	}
}
