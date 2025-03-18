import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String str;
	static int zero, one;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char num = str.charAt(i);

			while (i + 1 != str.length() && str.charAt(i + 1) == num) {
				i++;
			}

			if (num == '0') {
				zero++;
			} else {
				one++;
			}
		}

		System.out.println(Math.min(zero, one));
	}
}
