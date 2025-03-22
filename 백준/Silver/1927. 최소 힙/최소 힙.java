import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pqueue = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (pqueue.isEmpty()) {
					System.out.println("0 ");
				} else {
					System.out.println(pqueue.poll() + " ");
				}
			} else {
				pqueue.offer(num);
			}
		}

	}
}
