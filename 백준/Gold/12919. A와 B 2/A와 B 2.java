import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String S, T;
	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();

		dfs(T);
		int result = possible ? 1 : 0;

		System.out.println(result);
	}

	private static void dfs(String curr) {
		if (possible) {
			return;
		}

		if (curr.length() == S.length()) {
			if (S.equals(curr)) {
				possible = true;
			}
			return;
		}

		// 끝이 'A'면 제거
		if (curr.charAt(curr.length() - 1) == 'A') {
			dfs(curr.substring(0, curr.length() - 1));
		}

		// 시작이 'B'면 뒤집고 제거
		if (curr.charAt(0) == 'B') {
			String next = curr.substring(1);
			next = new StringBuilder(next).reverse().toString();
			dfs(next);
		}
	}
}