import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int T, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			char[] alpha = new char[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				alpha[j] = st.nextToken().charAt(0);
			}

            Deque<Character> deque = new ArrayDeque<>();
			deque.add(alpha[0]);

			for (int j = 1; j < N; j++) {
				Character ch = deque.peekFirst();

				if (ch >= alpha[j]) {
					deque.addFirst(alpha[j]);
				} else {
					deque.addLast(alpha[j]);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (char ch : deque) {
				sb.append(ch);
			}

			System.out.println(sb);
		}
	}
}
