import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static long result;
    
	static PriorityQueue<Jewel> jewels = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
	static PriorityQueue<Integer> bags = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			jewels.offer(new Jewel(weight, price));
		}

		for (int i = 0; i < K; i++) {
			int bag = Integer.parseInt(br.readLine());
			bags.offer(bag);
		}

		PriorityQueue<Jewel> priceQueue = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

		while(!bags.isEmpty()) {
			int bag = bags.poll();

			while (!jewels.isEmpty() && bag >= jewels.peek().weight) {
				priceQueue.offer(jewels.poll());
			}

			if (!priceQueue.isEmpty()) {
				result += priceQueue.poll().price;
			}
		}

		System.out.println(result);
	}

	static class Jewel {
		int weight;
		int price;

		Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}

}
