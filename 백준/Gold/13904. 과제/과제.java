import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static boolean[] days;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> workQueue = new PriorityQueue<>((n1, n2) -> {
			if (n1.w == n2.w) {
				return n1.d - n2.d;	// 과제점수가 같으면, 마감일 빠른 순
			}
			return n2.w - n1.w;		// 과제점수가 큰 순
		});

		N = Integer.parseInt(br.readLine());
		days = new boolean[1001];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			workQueue.offer(new Node(d, w));
		}

		while (!workQueue.isEmpty()){
			Node work = workQueue.poll();

			for (int i = work.d; i >= 1; i--) {
				if (!days[i]) {
					days[i] = true;
					result += work.w;
					break;
				}
			}
		}

		System.out.println(result);
	}

	static class Node {
		int d;
		int w;

		public Node(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
}
