import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int A, B, result;
	static Set<Integer> setA = new HashSet<>();
	static Set<Integer> setB = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}

		Set<Integer> diffA = new HashSet<>(setA);
		Set<Integer> diffB = new HashSet<>(setB);

		diffA.removeAll(setB);
		diffB.removeAll(setA);

		result = diffA.size() + diffB.size();
		System.out.println(result);

	}
}
