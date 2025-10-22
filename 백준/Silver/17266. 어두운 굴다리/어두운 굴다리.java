import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[M];

		if (M == 1) {
			System.out.println(N);
			return;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = arr[0];

		for (int i = 0; i < M - 1; i++) {
			int gap = arr[i + 1] - arr[i];
			result = Math.max(result, (gap + 1) / 2);
		}

		// 마지막 N까지
		result = Math.max(result, N - arr[M - 1]);

		System.out.println(result);
	}
}
