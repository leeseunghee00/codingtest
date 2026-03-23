import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W, X, Y;
	static int[][] arrA, arrB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		arrA = new int[H][W];
		arrB = new int[H + X][W + Y];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 겹치지 않는 영역 채우기
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (i == X && j == Y) {
					break;
				}
				arrA[i][j] = arrB[i][j];
			}
		}

		// 겹치는 영역 채우기
		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				arrA[i][j] = arrB[i][j] - arrA[i - X][j - Y];
			}
		}

		// 출력
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(arrA[i][j] + " ");
			}
			System.out.println();
		}
	}
}
