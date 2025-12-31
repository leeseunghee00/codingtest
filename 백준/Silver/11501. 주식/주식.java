import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			int[] stock = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int day = 1; day <= N; day++) {
				stock[day] = Integer.parseInt(st.nextToken());
			}

			int max = stock[N];
			long benefit = 0L;

			for (int day = N - 1; day > 0; day--) {
				int price = stock[day];

				// 현재 값 <= max -> 팔아
				if (price <= max) {
					benefit += (max - price);
				}
				// 현재 값 > max -> max 교체
				else {
					max = price;
				}
			}

			System.out.println(benefit);
		}
	}
}