import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static String str;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        Map<Character, Integer> words = new HashMap<>();

		str = sc.nextLine().toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			char alpha = str.charAt(i);
			int count = words.getOrDefault(alpha, 0);
			words.put(alpha, count + 1);
		}

		List<Character> list = new ArrayList<>(words.keySet());
		list.sort((c1, c2) -> words.get(c2).compareTo(words.get(c1)));

		if (list.size() == 1) {
			System.out.println(list.get(0));
			return;
		}

		char result = '?';
		int first = words.get(list.get(0));
		int second = words.get(list.get(1));

		if (first > second) {
			result = list.get(0);
		}

		System.out.println(result);
	}
}
