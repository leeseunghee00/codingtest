import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L, tapeEnd, result;
	static int[] hole;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		hole = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hole[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(hole);

		for (int i = 0; i < N; i++) {
			if (hole[i] > tapeEnd) {
				result++;
				tapeEnd = hole[i] + L - 1;
			}
		}

		System.out.println(result);
	}
}
