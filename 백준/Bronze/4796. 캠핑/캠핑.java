import java.util.Scanner;

public class Main {

	static int L, P, V, idx, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		idx = 1;

		while (true) {
			L = sc.nextInt();
			P = sc.nextInt();
			V = sc.nextInt();

			if (L == 0 && P == 0 && V == 0) {
				return;
			}

			result = L * (V / P) + Math.min(L, (V % P));

			System.out.println("Case " + idx + ": " + result);

			idx++;
		}
	}
}
