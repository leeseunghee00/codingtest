import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static String S;
	static Map<Character, Integer> words = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		S = sc.nextLine();

		for (int i = 0; i < 26; i++) {
			words.put((char)(97 + i), -1);
		}

		for (int i = 0; i < S.length(); i++) {
			char alpha = S.charAt(i);

			if (words.get(alpha) == -1) {
				words.put(alpha, i);
			}
		}

		for (Character alpha : words.keySet()) {
			System.out.print(words.get(alpha) + " ");
		}
	}
}
