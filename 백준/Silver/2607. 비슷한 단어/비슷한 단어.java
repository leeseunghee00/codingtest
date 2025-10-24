import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	static int N, result;
	static String base;
	static Map<Character, Integer> baseWord = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		base = br.readLine();

		for (char ch : base.toCharArray()) {
			baseWord.put(ch, baseWord.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < N - 1; i++) {
			String word = br.readLine();
			if (isSimilar(word)) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static boolean isSimilar(String str) {
		// 길이 확인
		int lengthDiff = Math.abs(base.length() - str.length());

		if (lengthDiff > 1) {
			return false;
		}

		// 단어 빈도 측정
		Map<Character, Integer> word = new HashMap<>();

		for (char ch : str.toCharArray()) {
			word.put(ch, word.getOrDefault(ch, 0) + 1);
		}

		// 두 단어의 빈도 차 확인
		Set<Character> set = new HashSet<>(baseWord.keySet());
		set.addAll(word.keySet());

		int countDiff = 0;

		for (char ch : set) {
			int b = baseWord.getOrDefault(ch, 0);
			int w = word.getOrDefault(ch, 0);

			countDiff += Math.abs(b - w);
		}

		// 같은 단어 or 추가/삭제 1번
        if (countDiff <= 1 || countDiff == 2 && base.length() == str.length()) {
			return true;
		}

		return false;
	}
}
