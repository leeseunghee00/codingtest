import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Map<String, Integer> directory = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			if (word.length() < M) {
				continue;
			}

			int count = directory.getOrDefault(word, 0);
			directory.put(word, count + 1);
		}

		List<String> wordList = new ArrayList<>(directory.keySet());

		wordList.sort((w1, w2) -> {
			int freqCompare = directory.get(w2).compareTo(directory.get(w1));

			if (freqCompare != 0) {
				return freqCompare;
			}

			int lengthCompare = Integer.compare(w2.length(), w1.length());

			if (lengthCompare != 0) {
				return lengthCompare;
			}

			return w1.compareTo(w2);
		});

		for (String word : wordList) {
			bw.write(word + "\n");
		}

		bw.flush();
		bw.close();
	}
}
