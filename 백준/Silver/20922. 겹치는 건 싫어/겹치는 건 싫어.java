import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, left, right, length;
	static int[] arr, countArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		countArr = new int[100001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (right < N) {
			int num = arr[right];

			if (countArr[num] < K) {
				countArr[num]++;
				right++;
				length = Math.max(right - left, length);
			} else {
				countArr[arr[left]]--;
				left++;
			}
		}

		System.out.println(length);
	}
}
