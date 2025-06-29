import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();

			if (str.equals("end")) {
				return;
			}

			sb.append("<").append(str).append(">");

			if (!checkConditions(str)) {
				sb.append(" is not acceptable.");
			} else {
				sb.append(" is acceptable.");
			}

			System.out.println(sb.toString());
		}
	}

	private static boolean checkConditions(String str) {
		// 모음 (aeiou) 포함
		if (!Vowel.contains(str)) {
			return false;
		}

		int vowelStreak = Vowel.isVowel(str.charAt(0)) ? 1 : 0;
		int consonantStreak = Vowel.isVowel(str.charAt(0)) ? 0 : 1;

		for (int i = 1; i < str.length(); i++) {
			char curr = str.charAt(i);
			char prev = str.charAt(i - 1);

			// 연달은 모음 3개 또는 자음 3개 확인
			if (Vowel.isVowel(curr)) {
				vowelStreak++;
				consonantStreak = 0;
			} else {
				consonantStreak++;
				vowelStreak = 0;
			}

			if (vowelStreak == 3 || consonantStreak == 3) {
				return false;
			}

			// 같은 문자 연속 확인 (ee, oo 은 허용)
			if (curr == prev && !(curr == 'e' || curr == 'o')) {
				return false;
			}
		}

		return true;
	}

	enum Vowel {
		a, e, i, o, u;

		static boolean contains(String str) {
			for (Vowel v : Vowel.values()) {
				if (str.contains(v.toString())) {
					return true;
				}
			}

			return false;
		}

		static boolean isVowel(char ch) {
			for (Vowel v : Vowel.values()) {
				if (ch == v.toString().charAt(0)) {
					return true;
				}
			}

			return false;
		}
	}
}
