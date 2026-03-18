import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, max;
	static char[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				search(i, j);
			}
		}

		System.out.println(max);
	}

	/* 사방탐색 */
	private static void search(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}

			if (arr[r][c] != arr[nr][nc]) {
				swap(r, c, nr, nc);
				check();
				swap(r, c, nr, nc);
			}
		}
	}

	/* 위치 스위치 */
	private static void swap(int r, int c, int nr, int nc) {
		char tmp = arr[r][c];
		arr[r][c] = arr[nr][nc];
		arr[nr][nc] = tmp;
	}

	/* 최댓값 찾기 */
	private static void check() {
		// 행 검사
		for (int i = 0; i < N; i++) {
			int count = 1;

			for (int j = 1; j < N; j++) {
				if (arr[i][j] == arr[i][j - 1]) {
					count++;
				} else {
					count = 1;
				}

				max = Math.max(count, max);
			}
		}

		// 열 검사
		for (int j = 0; j < N; j++) {
			int count = 1;

			for (int i = 1; i < N; i++) {
				if (arr[i][j] == arr[i - 1][j]) {
					count++;
				} else {
					count = 1;
				}

				max = Math.max(count, max);
			}
		}
	}
}
