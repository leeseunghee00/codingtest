import java.util.Scanner;

public class Main {

	static int N, result;
	static String[] str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = Integer.parseInt(sc.nextLine());
		str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = sc.nextLine();

			if (isGrowthWord(str[i])) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static boolean isGrowthWord(String word) {
		boolean[] alpha = new boolean[26];
		char preChar = '\0';

		for (int i = 0; i < word.length(); i++) {
			char curChar = word.charAt(i);

			if (preChar != curChar) {
				if (alpha[curChar - 'a']) {
					return false;
				}

				alpha[curChar - 'a'] = true;
			}

			preChar = curChar;
		}

		return true;
	}
}
