import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		visited = new boolean[N];

		dfs(0);
	}

	private static void dfs(int v) {

		if (v == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}

			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[v] = i + 1;
				dfs(v + 1);
				visited[i] = false;
			}
		}
	}
}
