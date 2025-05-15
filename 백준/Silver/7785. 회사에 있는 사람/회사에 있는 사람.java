import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Set<String> workers = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String workerName = st.nextToken();
			String commute = st.nextToken();

			if (workers.contains(workerName) && commute.equals("leave")) {
				workers.remove(workerName);
			} else {
				workers.add(workerName);
			}
		}

		List<String> result = new ArrayList<>(workers);
		result.sort(Collections.reverseOrder());

		for (String worker : result) {
			System.out.println(worker);
		}
	}
}
