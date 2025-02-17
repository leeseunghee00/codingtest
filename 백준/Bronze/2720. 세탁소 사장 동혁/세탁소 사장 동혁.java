import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int T, C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			C = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			if (C / 25 > 0) {
				sb.append(C / 25).append(" ");
				C = C % 25;
			} else {
				sb.append("0").append(" ");
			}

			if (C / 10 > 0) {
				sb.append(C / 10).append(" ");
				C = C % 10;
			} else {
				sb.append("0").append(" ");
			}

			if (C / 5 > 0) {
				sb.append(C / 5).append(" ");
				C = C % 5;
			} else {
				sb.append("0").append(" ");
			}

			sb.append(C / 1).append(" ");

			System.out.println(sb);
		}
	}

}
