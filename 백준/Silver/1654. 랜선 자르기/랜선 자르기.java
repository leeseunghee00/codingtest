import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static long result;
	static int[] lan;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		lan = new int[N];
		long max = 0;

		for (int i = 0; i < N; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}

		long left = 1;
		long right = max;

		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < N; i++) {
				count += (lan[i] / mid);
			}

			if (count < K) {
				right = mid - 1;
			} else {
				result = mid;
				left = mid + 1;
			}
		}

		System.out.println(result);
	}
}
