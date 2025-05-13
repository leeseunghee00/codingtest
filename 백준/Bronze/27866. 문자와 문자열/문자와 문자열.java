import java.util.Scanner;

public class Main {

	static String S;
	static int idx;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		S = sc.nextLine();
		idx = sc.nextInt();

		System.out.println(S.charAt(idx - 1));
	}
}
