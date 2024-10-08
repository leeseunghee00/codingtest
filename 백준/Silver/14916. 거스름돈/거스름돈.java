import java.util.Scanner;

public class Main {

	static int n, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		while (n >= 0) {
			if (n % 5 == 0) {
				result += n / 5;
				System.out.println(result);
				return;
			}

			n -= 2;
			result++;
		}
		
		System.out.println("-1");
	}
}
