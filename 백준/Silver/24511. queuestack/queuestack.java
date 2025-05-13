import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Set<Integer> queueIdx = new HashSet<>();
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());

			if (a == 0) {
				queueIdx.add(i);
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int b = Integer.parseInt(st.nextToken());

			if (queueIdx.contains(i)) {
				deque.addLast(b);
			}
		}

		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int c = Integer.parseInt(st.nextToken());

			if (queueIdx.isEmpty()) {
				sb.append(c).append(" ");
			} else {
				sb.append(deque.pollLast()).append(" ");
				deque.addFirst(c);
			}
		}

		System.out.println(sb);

	}
}

