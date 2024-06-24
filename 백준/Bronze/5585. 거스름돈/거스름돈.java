import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] yen = {500, 100, 50, 10, 5, 1};
		int N = sc.nextInt();
		int change = 1000 - N;
		int result = 0;

		for (int i = 0; i < yen.length; i++) {

			if (change >= yen[i]) {
				result += (change / yen[i]);
				change %= yen[i];
			}
		}

		System.out.println(result);
	}
}