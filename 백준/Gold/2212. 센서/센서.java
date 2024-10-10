import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, K, result;
	static int[] sensor;
	static Integer[] diff;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		sensor = new int[N];
		diff = new Integer[N - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor);

		for (int i = 1; i < N; i++) {
			diff[i - 1] = sensor[i] - sensor[i - 1];
		}

		Arrays.sort(diff, Collections.reverseOrder());

		for (int i = K - 1; i < N - 1; i++) {
			result += diff[i];
		}

		System.out.println(result);
	}
}
