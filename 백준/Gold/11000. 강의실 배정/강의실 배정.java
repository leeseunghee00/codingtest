import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> classQueue = new PriorityQueue<>((n1, n2) -> n1.startTime - n2.startTime);
		PriorityQueue<Integer> roomQueue = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			classQueue.offer(new Node(startTime, endTime));
		}

		Node firstClass = classQueue.poll();
		roomQueue.offer(firstClass.endTime);
		result++;

		while (!classQueue.isEmpty()){
			Node curClass = classQueue.poll();

			if (curClass.startTime >= roomQueue.peek()) {
				roomQueue.poll();
			} else {
				result++;
			}

			roomQueue.offer(curClass.endTime);
		}

		System.out.println(result);
	}

	static class Node {
		int startTime;
		int endTime;

		public Node(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}
