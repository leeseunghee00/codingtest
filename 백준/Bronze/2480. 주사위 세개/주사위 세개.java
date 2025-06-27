import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int result;
	static Map<Integer, Integer> number = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			int num = sc.nextInt();
			int value = number.getOrDefault(num, 0);
			number.put(num, value + 1);
		}

		if (number.size() == 1) {
			int key = number.keySet().iterator().next();
			result = 10000 + (key * 1000);
		} else if (number.size() == 2) {
			int key = 0;

			for (Map.Entry<Integer, Integer> entry : number.entrySet()) {
				if (entry.getValue() == 2) {
					key = entry.getKey();
					break;
				}
			}

			result = 1000 + (key * 100);
		} else {
			int key = Collections.max(number.keySet());
			result = (key * 100);
		}

		System.out.println(result);
	}
}
