import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (R-- > 0) {
			int[][] temp = new int[N + 1][M + 1];
			int startY = 1, startX = 1, endY = N, endX = M;

			while (startX <= Math.min(N, M) / 2) {
				rotate(startY, startX, endY, endX, temp);
				startY++;
				startX++;
				endY--;
				endX--;
			}

			arr = temp;
		}

		// 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotate(int startY, int startX, int endY, int endX, int[][] temp) {

		// 위
		for (int x = startX; x < endX; x++) {
			temp[startY][x] = arr[startY][x + 1];
		}

		// 오른쪽
		for (int y = startY; y < endY; y++) {
			temp[y][endX] = arr[y + 1][endX];
		}

		// 아래
		for (int x = endX; x > startX; x--) {
			temp[endY][x] = arr[endY][x - 1];
		}

		// 왼쪽
		for (int y = endY; y > startY; y--) {
			temp[y][startX] = arr[y - 1][startX];
		}
	}
}
