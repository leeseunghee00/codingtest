import java.util.Scanner;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		sb.append((int) Math.pow(2, N) - 1).append("\n");
		hanoi(N, 1, 3, 2);

		System.out.println(sb);
	}

	private static void hanoi(int n, int from, int to, int mid) {
		if (n == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}

		hanoi(n - 1, from, mid, to);
		sb.append(from + " " + to + "\n");
		hanoi(n - 1, mid, to, from);
	}
}
