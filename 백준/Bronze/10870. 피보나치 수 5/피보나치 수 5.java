import java.util.Scanner;

public class Main {

	static int N, result;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];

		result = fibonacci(N);

		System.out.println(result);
	}

	private static int fibonacci(int idx) {
		if (idx == 0) {
			return 0;
		}
		else if (idx == 1) {
			return 1;
		}
		else {
			return fibonacci(idx - 1) + fibonacci(idx - 2);
		}
	}
}
