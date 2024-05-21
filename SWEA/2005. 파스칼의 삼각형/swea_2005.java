import java.util.Scanner;

public class swea_2005 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] A = new int[N + 1][N + 1];

			// 첫 번째 수 초기화
			for (int i = 0; i < N; i++) {
				A[0][i] = 1;
			}

			// 나머지 구하기
			for (int i = 1; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						A[i][j] = 1;
					} else {
						A[i][j] = A[i - 1][j - 1] + A[i - 1][j];
					}
				}
			}

			// 출력
			System.out.println("#" + test_case);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(A[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
