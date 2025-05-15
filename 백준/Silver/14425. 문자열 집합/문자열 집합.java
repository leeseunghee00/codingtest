import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static Set<String> strSet = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			strSet.add(str);
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();

			if (strSet.contains(str)) {
				result++;
			}

		}

		System.out.println(result);
	}
}
