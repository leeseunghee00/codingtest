import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, result;
	static int[] queen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		queen = new int[N];

		nqueen(0);

		System.out.println(result);
	}

	private static void nqueen(int r) {
		if (r == N) {
			result++;
			return;
		}

		for (int c = 0; c < N; c++) {
			queen[r] = c;

			if (check(r)) {
				nqueen(r + 1);
			}
		}
	}

	private static boolean check(int r) {
		for (int i = 0; i < r; i++) {
			// 같은 열
			if (queen[r] == queen[i]) {
				return false;
			}

			// 대각선
			if (Math.abs(r - i) == Math.abs(queen[r] - queen[i])) {
				return false;
			}
		}

		return true;
	}
}
