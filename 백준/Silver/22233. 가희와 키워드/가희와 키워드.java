import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Set<String> words = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			words.add(word);
		}

		for (int i = 0; i < M; i++) {
			String[] keywords = br.readLine().split(",");

			for (String keyword : keywords) {
				if (words.contains(keyword)) {
					words.remove(keyword);
				}
			}

			System.out.println(words.size());
		}
	}
}
