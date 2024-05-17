package leeseunghee.study.swea;

import java.util.Scanner;

public class swea_1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String num = Integer.toString(test_case);

			if (num.contains("3") || num.contains("6") || num.contains("9")) {
				for (int i = 0; i < num.length(); i++) {
					if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
						System.out.print("-");
					}
				}
				System.out.print(" ");
			} else {
				System.out.print(test_case + " ");
			}
		}
	}
}
