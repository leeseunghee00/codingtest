import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int i = line.length() - 1;

		while (i >= 0) {
			// 문자 `=` 일 경우
			if (line.charAt(i) == '=') {
				if (i - 2 >= 0 && line.charAt(i - 2) == 'd' && line.charAt(i - 1) == 'z') {
					i -= 3;
				} else {
					i -= 2;
				}

				result++;
				continue;
			}

			// 문자 `-` 일 경우
			if (line.charAt(i) == '-') {
				i -= 2;
				result++;
				continue;
			}

			// 문자 `j` 일 경우
			if (line.charAt(i) == 'j') {
				if (i - 1 >= 0 && (line.charAt(i - 1) == 'l' || line.charAt(i - 1) == 'n')) {
					i -= 2;
					result++;
					continue;
				}
			}

			result++;
			i--;
		}

		System.out.println(result);
	}

}
