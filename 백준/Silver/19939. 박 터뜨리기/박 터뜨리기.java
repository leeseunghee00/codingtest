import java.util.Scanner;

public class Main {

	static int N, K, result;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		if (N < (K * (K + 1) / 2)) {
			System.out.println("-1");
			return;
		}

		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = i + 1;
		}

		int ball = N - (K * (K + 1) / 2);	// 최소 필요한 공 갯수 구하기
		int index = K - 1;

		while (ball > 0) {
			arr[index]++;
			ball--;
			index = (index - 1 + K) % K;
		}

		int max = arr[0], min = arr[0];

		for (int i = 1; i < K; i++) {
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}

		result = max - min;
		System.out.println(result);
	}
}
