import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] local;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		local = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = 0, right = 0;

		for (int i = 0; i < N; i++) {
			local[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, local[i]);
		}

		M = Integer.parseInt(br.readLine());

		// 이분탐색: 상한값 계산
		while (left <= right) {
			int mid = (left + right) / 2;
			long budget = 0;

			for (int i = 0; i < N; i++) {
				if (local[i] < mid) {
					budget += local[i];
				} else {
					budget += mid;
				}
			}

			if (budget <= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}
