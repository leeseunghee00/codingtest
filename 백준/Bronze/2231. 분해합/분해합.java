import java.util.Scanner;

public class Main {

	static int N, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 1; i < N; i++) {
			if (splitSum(i) == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

	private static int splitSum(int num) {
		int sum = num;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}
}
