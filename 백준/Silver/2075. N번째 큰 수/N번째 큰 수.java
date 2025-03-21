import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(findMaxN(N));
	}

	private static int findMaxN(int n) {

		List<Integer> list = new ArrayList<>();

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				list.add(arr[i][j]);
			}
		}

		list.sort((o1, o2) -> o2 - o1);

		return list.get(n - 1);
	}
}
