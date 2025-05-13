import java.util.Scanner;

public class Main {

	static int T;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		while (T-- > 0) {
			String str = sc.next();
			StringBuilder sb = new StringBuilder();

			sb.append(str.charAt(0)).append(str.charAt(str.length() - 1));

			System.out.println(sb);
		}
	}
}
