import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N, result;
	static PriorityQueue<Integer> list = new PriorityQueue<>((o1 ,o2) -> o2 - o1);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (list.isEmpty()) {
					System.out.println("0");
				} else {
					result = list.poll();
					System.out.println(result);
				}
			} else {
				list.offer(num);
			}
		}
	}
}
