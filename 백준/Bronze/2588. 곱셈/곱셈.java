import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		String N = sc.next();

		System.out.println(M * (N.charAt(2) - '0'));
		System.out.println(M * (N.charAt(1) - '0'));
		System.out.println(M * (N.charAt(0) - '0'));
		System.out.println(M * Integer.parseInt(N));
	}
}
