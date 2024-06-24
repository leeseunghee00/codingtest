import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 2. 값 정렬
		Arrays.sort(arr);

		// 3. 합 배열
		int[] total = new int[N];

		total[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			total[i] = total[i - 1] + arr[i];
		}
		
		// 4. 3번 배열의 총 합
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			result += total[i];
		}

		System.out.println(result);
	}
}
