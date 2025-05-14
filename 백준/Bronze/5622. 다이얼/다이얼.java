import java.util.Scanner;

public class Main {

	static String str;
	static int time;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char alpha = str.charAt(i);

			if (alpha < 68) {	// ABC
				time += 3;
			} else if (alpha < 71) {	// DEF
				time += 4;
			} else if (alpha < 74) {	// GHI
				time += 5;
			} else if (alpha < 77) {	// JKL
				time += 6;
			} else if (alpha < 80) {	// MNO
				time += 7;
			} else if (alpha < 84) {	// PQRS
				time += 8;
			} else if (alpha < 87) {	// TUV
				time += 9;
			} else {	// WXYZ
				time += 10;
			}
		}

		System.out.println(time);
	}
}
