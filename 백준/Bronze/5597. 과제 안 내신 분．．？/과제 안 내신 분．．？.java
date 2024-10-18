import java.util.Scanner;

public class Main {

	static boolean[] students;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		students = new boolean[31];

		for (int i = 0; i < 28; i++) {
			int num = sc.nextInt();
			students[num] = true;
		}

		for (int i = 1; i <= 30; i++) {
			if (!students[i]) {
				System.out.println(i);
			}
		}
	}
}
