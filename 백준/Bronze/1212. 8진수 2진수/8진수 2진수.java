import java.util.Scanner;

public class Main {
	static String N;
	static String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

		N = sc.nextLine();

		int firstNum = N.charAt(0) - '0';
		sb.append(Integer.toBinaryString(firstNum));	// 앞에 0 제외하고 반환

		for (int i = 1; i < N.length(); i++) {
			int num = N.charAt(i) - '0';
			sb.append(arr[num]);
		}

		System.out.println(sb);
	}
}
