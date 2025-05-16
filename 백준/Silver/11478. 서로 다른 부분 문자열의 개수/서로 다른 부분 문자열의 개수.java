import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static String S;
	static Set<String> partS = new HashSet<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		S = sc.nextLine();

		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j <= S.length(); j++) {
				String subStr = S.substring(i, j);
				partS.add(subStr);
			}
		}

		System.out.println(partS.size());
	}
}
