import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long result;
	static int[] trees;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		trees = new int[N];

		st = new StringTokenizer(br.readLine());
		int max = 0;

		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		long left = 1;
		long right = max;

		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < N; i++) {
				if (trees[i] > mid) {
					count += (trees[i] - mid);
				}
			}

			if (count < M) {
				right = mid	- 1;
			} else {
				result = mid;
				left = mid + 1;
			}
		}

		System.out.println(result);
	}
}
