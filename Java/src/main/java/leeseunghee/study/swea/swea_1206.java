package leeseunghee.study.swea;

import java.util.Scanner;

public class swea_1206 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[] A = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			int ans = 0;

			for (int i = 2; i < N - 2; i++) {
				int max = Math.max(A[i - 2], Math.max(A[i - 1], Math.max(A[i + 1], A[i + 2])));

				if (A[i] - max > 0) {
					ans += A[i] - max;
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}
}
