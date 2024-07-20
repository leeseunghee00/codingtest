import java.util.Scanner;

public class Main {

	static int A, B, sum;
	static int[] arr = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();

		// 초기화
		int cur = 1, num = 1;
		while (cur <= 1000) {
			for (int i = 0; i < num && cur <= 1000; i++) {
				arr[cur] = num;
				cur++;
			}
			num++;
		}

		for (int i = A; i <= B; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}
}
