import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());

			if (order <= 2) {
				int inputNum = Integer.parseInt(st.nextToken());

				if (order == 1) {
					deque.addFirst(inputNum);
				} else {
					deque.addLast(inputNum);
				}
			} else if (order <= 4) {
				if (!deque.isEmpty() && order == 3) {
					System.out.println(deque.pollFirst());
				} else if (!deque.isEmpty() && order == 4) {
					System.out.println(deque.pollLast());
				} else {
					System.out.println("-1");
				}
			} else if (order == 5) {
				System.out.println(deque.size());
			} else if (order == 6) {
				int result = deque.isEmpty() ? 1 : 0;
				System.out.println(result);
			} else {
				if (!deque.isEmpty() && order == 7) {
					System.out.println(deque.getFirst());
				} else if (!deque.isEmpty() && order == 8) {
					System.out.println(deque.getLast());
				} else {
					System.out.println("-1");
				}
			}
		}
		
	}
}
