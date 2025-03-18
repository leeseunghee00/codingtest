import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		divide(0, 0, N);

		System.out.println(sb.toString());
	}

	private static void divide(int y, int x, int n) {

		if (check(y, x, n)) {
			sb.append(arr[y][x]);
		} else {
			sb.append("(");

			int half = n / 2;

			divide(y, x, half);
			divide(y, x + half, half);
			divide(y + half, x, half);
			divide(y + half, x + half, half);

			sb.append(")");
		}
	}

	private static boolean check(int y, int x, int n) {
		char ch = arr[y][x];

		for (int r = y; r < y + n; r++) {
			for (int c = x; c < x + n; c++) {
				if (arr[r][c] != ch) {
					return false;
				}
			}
		}

		return true;
	}
}
