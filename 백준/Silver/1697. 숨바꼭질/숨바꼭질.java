import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static ArrayDeque<Integer> deque = new ArrayDeque<>();
	static final int MAX = 100_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		int[] dist = new int[MAX + 1];
		Arrays.fill(dist, -1);
		dist[N] = 0;

		deque.offer(N);

		while (!deque.isEmpty()) {
			int curr = deque.poll();

			if (curr == K) {
				break;
			}

			int[] arrange = {curr - 1, curr + 1, curr * 2};

			for (int num : arrange) {
				if (num < 0 || num > MAX || dist[num] != -1) {
					continue;
				}

				dist[num] = dist[curr] + 1;
				deque.offer(num);
 			}
		}

		System.out.println(dist[K]);
	}
}
