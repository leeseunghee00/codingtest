import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		if (N % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}