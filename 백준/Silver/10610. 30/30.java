import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
	static int zeroCnt, mul;
	static String N;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextLine();

		num = Arrays.stream(N.split(""))
			.mapToInt(Integer::parseInt)
			.toArray();

		Arrays.sort(num);
		
		for (int n : num) {
			if (n == 0) {
				zeroCnt++;
			}

			mul += n;
			sb.append(n);
		}

		if (zeroCnt == 0 || mul % 3 != 0) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(sb.reverse());
	}
}
