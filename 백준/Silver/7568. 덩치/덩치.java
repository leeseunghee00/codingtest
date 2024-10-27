import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][2];
		result = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			result[i] = 1;

			for (int j = 0; j < N; j++) {
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					result[i]++;
				}
			}
		}

		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
