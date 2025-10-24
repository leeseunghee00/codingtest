import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<String> names = new ArrayList<>();
	static List<Integer> powers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int power = Integer.parseInt(st.nextToken());

			if (powers.isEmpty() || powers.get(powers.size() - 1) != power) {
				names.add(name);
				powers.add(power);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(findTitle(num)).append('\n');
		}

		System.out.println(sb);
	}

	private static String findTitle(int num) {
		int left = 0, right = powers.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (num <= powers.get(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return names.get(left);
	}
}
