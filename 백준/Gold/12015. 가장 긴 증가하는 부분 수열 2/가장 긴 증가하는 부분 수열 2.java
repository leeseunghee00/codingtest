import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static ArrayList<Integer> LIS = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int num : A) {
			if (LIS.isEmpty() || LIS.get(LIS.size() - 1) < num) {
				LIS.add(num);
			} else {
				int left = 0;
				int right = LIS.size() - 1;

				while (left < right) {
					int mid = (left + right) / 2;

					if (LIS.get(mid) < num) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}

				LIS.set(left, num);
			}
		}

		System.out.println(LIS.size());
	}
}
