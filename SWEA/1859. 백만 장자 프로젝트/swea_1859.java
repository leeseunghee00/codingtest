import java.util.Scanner;

public class swea_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[] number = new int[N];

			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();
			}

			long benefit = 0;
			int s = 0;

			while (s < N) {
				int maxIdx = s;

				for (int j = s + 1; j < N; j++) {
					if (number[maxIdx] < number[j]) {
						maxIdx = j;
					}
				}

				for (int k = s; k < maxIdx; k++) {
					benefit += (number[maxIdx] - number[k]);
				}

				s = maxIdx + 1;
			}

			System.out.println("#" + test_case + " " + benefit);
		}
	}
}
