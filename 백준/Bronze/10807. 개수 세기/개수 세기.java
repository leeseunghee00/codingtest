import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, v, result;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		v = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int idx = 0;

		while (idx < N && arr[idx] != v) {
			idx++;
		}

		if (idx == N) {
			System.out.println(0);
			return;
		}

		while (idx < N && arr[idx] == v) {
			idx++;
			result++;
		}

		System.out.println(result);
	}
}
