import java.util.Scanner;

public class Main {

	static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		int room = 1;
		int range = 1;

		while (range < n) {
			range += 6 * room;
			room++;
		}

		System.out.println(room);
	}
}
