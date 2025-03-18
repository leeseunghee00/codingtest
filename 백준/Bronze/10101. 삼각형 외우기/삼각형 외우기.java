import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int sum;
	static int[] triangle = new int[3];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			triangle[i] = Integer.parseInt(br.readLine());
			sum += triangle[i];
		}

		// 모두 해당되지 않을 때
		if (sum != 180) {
			System.out.println("Error");
			return;
		}

		Arrays.sort(triangle);

		// 세 각이 모두 60
		boolean isEquilateral = true;
		for (int i = 0; i < 3; i++) {
			if (triangle[i] != 60) {
				isEquilateral = false;
				break;
			}
		}

		if (isEquilateral) {
			System.out.println("Equilateral");
			return;
		}

		// 두 각이 같은 때
		if (triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2]) {
			System.out.println("Isosceles");
			return;
		}

		// 같은 각이 없을 때
		System.out.println("Scalene");

	}
}
