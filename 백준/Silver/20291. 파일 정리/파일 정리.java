import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static HashMap<String, Integer> extension = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String[] file = sc.nextLine().split("\\.");

			if (!extension.containsKey(file[1])) {
				extension.put(file[1], 1);
			} else {
				int value = extension.get(file[1]) + 1;
				extension.put(file[1], value);
			}
		}

		List<String> key = new ArrayList<>(extension.keySet());

		Collections.sort(key);

		for (int i = 0; i < key.size(); i++) {
			int value = extension.get(key.get(i));
			System.out.println(key.get(i) + " " + value);
		}
	}
}
