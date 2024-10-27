import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W;
	static char[][] arr;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new char[H][W];
		result = new int[H][W];

		for (int i = 0; i < H; i++) {
			String str = br.readLine().trim();
			arr[i] = str.toCharArray();
		}

		for (int i = 0; i < H; i++) {
			int cloud = -1;

			for (int j = 0; j < W; j++) {
				if (arr[i][j] == 'c') {
					result[i][j] = 0;
					cloud = 0;
				} else if (cloud >= 0) {
					cloud++;
					result[i][j] = cloud;
				} else {
					result[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
