import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, count;
	static Set<String> roster = new HashSet<>();
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			roster.add(name);
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();

			if (roster.contains(name)) {
				count++;
				result.add(name);
			}
		}

		result.sort(String::compareTo);

		System.out.println(count);
		for (String name : result) {
			System.out.println(name);
		}
	}
}
