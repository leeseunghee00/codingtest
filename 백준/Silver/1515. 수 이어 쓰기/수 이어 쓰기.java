import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		target = br.readLine();

		int idx = 0;

		for (int num = 1; ; num++) {
			String tmp = String.valueOf(num);

			for (int k = 0; k < tmp.length() && idx < target.length(); k++) {
				if (tmp.charAt(k) == target.charAt(idx)) {
					idx++;
				}
			}

			if (idx == target.length()) {
				System.out.println(num);
				return;
			}
		}

	}
}
