import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, result, count;
	static String[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			String str = arr[i];

			count = 0;
			result = isPalindrome(str);

			System.out.println(result + " " + count);
		}
	}

	private static int isPalindrome(String str) {
		return recursion(str, 0, str.length() - 1);
	}

	private static int recursion(String str, int l, int r) {
		count++;

		if (l >= r) {
			return 1;
		} else if (str.charAt(l) != str.charAt(r)) {
			return 0;
		} else {
			return recursion(str, l + 1, r - 1);
		}
	}
}
