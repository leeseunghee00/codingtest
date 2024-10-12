import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int preX = arr[0][0];
		int preY = arr[0][1];
		result = preY - preX;

		for (int i = 1; i < N; i++) {
			int curX = arr[i][0];
			int curY = arr[i][1];

			if (curX <= preY) { // 현재 선이 이전 선과 겹칠 경우
				if (curY > preY) { // 겹치지만 더 긴 경우
					result += curY - preY;
					preY = curY;
				}
			} else { // 겹치지 않는 경우
				result += curY - curX;
				preY = curY;
			}
		}

		System.out.println(result);
	}
}
