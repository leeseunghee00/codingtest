import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static int[] arr = new int[11];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Arrays.fill(arr, -1);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int cow = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());

			if (arr[cow] == -1) {
				arr[cow] = loc;
			} else if (arr[cow] != loc) {
				arr[cow] = loc;
				result++;
			}
		}

		System.out.println(result);
	}
}
