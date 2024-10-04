import java.util.Scanner;

public class Main {

	static int A, B, C, M;
	static int sleepy, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();

		if (A > M) {
			System.out.println("0");
			return;
		}

		for (int i = 0; i < 24; i++) {
			if (sleepy + A <= M) {
				sleepy += A;
				result += B;
			} else {
				sleepy -= C;

				if (sleepy < 0) {
					sleepy = 0;
				}
			}
		}

		System.out.println(result);
	}
}
