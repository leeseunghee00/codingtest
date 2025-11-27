import java.util.Scanner;

public class Main {

	static int n, result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		int r = n % 8;

		if (r >= 1 && r <= 5) {
			result = r;
		} else if (r == 6 || r == 7) {
			result = 10 - r;
		} else {
			result = 2;
		}

		System.out.println(result);
	}
}