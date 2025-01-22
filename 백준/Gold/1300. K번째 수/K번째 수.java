import java.util.Scanner;

public class Main {

	static int N;
	static long k, result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		k = sc.nextLong();

		long left = 1, right = k;

		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}

			if (count >= k) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(result);
	}
}
