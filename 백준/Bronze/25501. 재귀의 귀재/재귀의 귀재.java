import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int T, count;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			str = br.readLine();
			count = 0;

			int result = isPalindrome(str);
			System.out.println(result + " " + count);
		}
	}

	public static int recursion(String s, int left, int right) {
		count++;

		if (left >= right) {
			return 1;
		} else if (s.charAt(left) != s.charAt(right)) {
			return 0;
		} else {
			return recursion(s, left + 1, right - 1);
		}
	}

	private static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}
}
