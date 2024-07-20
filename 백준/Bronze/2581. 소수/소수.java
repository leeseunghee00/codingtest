import java.util.Scanner;

public class Main {

	static int M, N, sum, min;
	static int[] prime = new int[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		// 초기화
		for (int i = 2; i < 10001; i++) {
			if (isPrime(i)) {
				prime[i] = i;
			} else {
				prime[i] = 0;
			}
		}

		for (int i = M; i <= N; i++) {
			sum += prime[i];

			if (min == 0 && prime[i] != 0) {
				min = prime[i];
			}

			if (prime[i] != 0 && prime[i] < min) {
				min = prime[i];
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	// 소수 판별
	private static boolean isPrime(int x) {
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}
}
