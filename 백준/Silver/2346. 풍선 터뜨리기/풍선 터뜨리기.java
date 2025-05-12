import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Deque<Balloon> deque = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int move = Integer.parseInt(st.nextToken());
			deque.offer(new Balloon(i + 1, move));
		}

		while (!deque.isEmpty()) {
			Balloon balloon = deque.removeFirst();

			sb.append(balloon.idx).append(" ");
			int move = balloon.move;

			if (deque.isEmpty()) {
				break;
			}

			if (move > 0) {
				for (int i = 0; i < move - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
			} else {
				for (int i = 0; i < -move; i++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}

		System.out.println(sb);
	}

	static class Balloon {
		int idx;
		int move;

		Balloon(int idx, int move) {
			this.idx = idx;
			this.move = move;
		}
	}
}
