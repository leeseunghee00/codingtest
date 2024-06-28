import java.util.Scanner;

public class Main {

	static int cnt1, cnt2;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N + 1];

		fibo(N);
		fibonacci(N);

		System.out.print(++cnt1 + " " + cnt2);
	}

	private static int fibo(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		cnt1++;

		return fibo(n - 1) + fibo(n - 2);
	}

	private static void fibonacci(int n) {
		arr[1] = arr[2] = 1;

		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			cnt2++;
		}
	}
}
