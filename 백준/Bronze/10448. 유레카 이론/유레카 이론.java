import java.util.Scanner;

public class Main {

	static int K;
	static int[] T = new int[46];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();

		// 삼각수 초기화
		for (int i = 1; i <= 45; i++) {
			T[i] = i * (i + 1) / 2;
		}

		while (K-- > 0) {
			int N = sc.nextInt();
			boolean flag = false;

			for (int i = 1; i < 46; i++) {
				for (int j = 1; j < 46; j++) {
					for (int z = 1; z < 46; z++) {
						if (T[i] + T[j] + T[z] == N) {
							flag = true;
							break;
						}
					}
					if (flag) break;
				}
				if (flag) break;
			}

			System.out.println(flag ? 1 : 0);
		}
	}
}
