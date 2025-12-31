import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int N;
	static List<String> words = new ArrayList<>();

	static Map<Character, Boolean> usedKey = new HashMap<>();
	static Map<Integer, Integer> selectPos = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int line = 0; line < N; line++) {
			String word = br.readLine();
			words.add(word);

			int pos = -1, idx = 0;
			String[] parts = word.split(" ");

			// 첫글자 단축키 존재 유무 확인
			for (String part : parts) {
				char key = Character.toLowerCase(part.charAt(0));

				if (!usedKey.containsKey(key)) {
					usedKey.put(key, true);
					pos = idx;
					break;
				}

				idx += part.length() + 1;
			}

			// 단축키가 존재한다면, 왼쪽부터 차례대로 훑어보기
			if (pos == -1) {
				for (int i = 0; i < word.length(); i++) {
					char ch = word.charAt(i);

					if (ch == ' ') {
						continue;
					}

					char key = Character.toLowerCase(ch);

					if (!usedKey.containsKey(key)) {
						usedKey.put(key, true);
						pos = i;
						break;
					}
				}
			}

			selectPos.put(line, pos);
		}

		// 출력
		for (int i = 0; i < N; i++) {
			String word = words.get(i);
			int pos = selectPos.get(i);

			// 단축키 없는 경우
			if (pos == -1) {
				System.out.println(word);
			} else {
				// 단축키 있는 경우
				System.out.println(
					word.substring(0, pos) + "[" + word.charAt(pos) + "]" + word.substring(pos + 1)
				);
			}
		}
	}
}