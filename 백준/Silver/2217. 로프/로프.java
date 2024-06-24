import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] w = new int[N];
		int maxWeight = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
		}

		Arrays.sort(w);

		for (int i = 0; i < N; i++) {
			int weight = w[i] * (N - i);
			if (weight > maxWeight) {
				maxWeight = weight;
			}
		}

		System.out.println(maxWeight);
	}
}
