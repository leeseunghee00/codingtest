import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean flag;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		if (flag) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	private static void dfs(int a, int b) {
		// 배열 행 또는 열 끝에 왔을 때
		if (a >= N || b >= N || visited[a][b] || flag) {
			return;
		}

		visited[a][b] = true;
		int move = arr[a][b];

		dfs(a + move, b); // 오른쪽
		dfs(a, b + move); // 아래

		if (a == N - 1 && b == N - 1) {
			if (arr[a][b] == -1) {
				flag = true;
			}
		}
	}
}
