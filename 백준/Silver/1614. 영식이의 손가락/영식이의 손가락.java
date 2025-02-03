import java.util.Scanner;

public class Main {

	static long N, M;
	static long result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextLong();
		M = sc.nextLong();

		if (N == 1) {
			result =  M * 8;
		} else if (N == 2) {
			result = 1 + (M / 2) * 8 + (M % 2) * 6;
		} else if (N == 3) {
			result = 2 + (M / 2) * 8 + (M % 2) * 4;
		} else if (N == 4) {
			result = 3 + (M / 2) * 8 + (M % 2) * 2;
		} else {
			result = 4 + M * 8;
		}

		System.out.println(result);
	}
}