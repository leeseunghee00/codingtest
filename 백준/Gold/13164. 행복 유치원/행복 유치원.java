import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, K, result;
	static int[] child;
	static Integer[] diff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		child = new int[N];
		diff = new Integer[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			child[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(child);

		for (int i = 1; i < N; i++) {
			diff[i - 1] = child[i] - child[i - 1];
		}

		Arrays.sort(diff, Collections.reverseOrder());

		for (int i = K - 1; i < N - 1; i++) {
			result += diff[i];
		}

		System.out.println(result);
	}
}
