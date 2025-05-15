import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N, result;
	static PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>((o1, o2) -> {

		if (Math.abs(o1) == Math.abs(o2)) {
			return Integer.compare(o1, o2);
		}

		return Math.abs(o1) - Math.abs(o2);
	});

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (priorityQueue.isEmpty()) {
					System.out.println("0");
				} else {
					result = priorityQueue.poll();
					System.out.println(result);
				}
			} else {
				priorityQueue.offer(num);
			}
		}
	}
}
