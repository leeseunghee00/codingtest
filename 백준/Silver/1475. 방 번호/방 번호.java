import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		int[] count = new int[11];

		for (char ch : line.toCharArray()) {
			count[ch - '0']++;
		}

		int sixNine = count[6] + count[9];
		count[6] = count[9] = (sixNine + 1) / 2;

		int result = 0;

		// 가장 많이 필요한 숫자 찾기
		for (int i = 0; i < 10; i++) {
			result = Math.max(result, count[i]);
		}

		System.out.println(result);
	}
}
