import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];

		dfs(0, 0);
	}

	private static void dfs(int start, int depth) {

		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}

			System.out.println();
            
			return;
		}

		for (int i = start; i < N; i++) {
			arr[depth] = i + 1;
			dfs(i + 1, depth + 1);
		}
	}
}
