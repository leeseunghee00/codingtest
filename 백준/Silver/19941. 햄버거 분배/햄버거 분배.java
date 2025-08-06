import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		char[] arr = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			if (arr[i] == 'P') {
				int left = Math.max(i - K, 0);
				int right = Math.min(i + K, N - 1);

				for (int j = left; j <= right; j++) {
					if (arr[j] == 'H') {
						count++;
						arr[j] = 'X';
						break;
					}
				}
			}
		}

		System.out.println(count);
	}
}
