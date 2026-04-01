import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		backtracking(new ArrayList<>(), 0);

		System.out.println(sb.toString());
	}

	private static void backtracking(List<Character> list, int start) {
		if (list.size() == L) {
			if (!check(list)) {
				return;
			}

			for (char ch : list) {
				sb.append(ch);
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			list.add(arr[i]);
			backtracking(list, i + 1);
			list.remove(list.size() - 1);
		}
	}

	private static boolean check(List<Character> list) {
		int vowel = 0;
		int consonant = 0;
		
		for (char ch : list) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowel++;
			} else {
				consonant++;
			}
		}
		
		if (vowel >= 1 && consonant >= 2) {
			return true;
		}
		
		return false;
	}
}
