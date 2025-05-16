import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Map<String, Integer> nameToNum = new HashMap<>();
	static Map<Integer, String> numToName = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			String pokemon = br.readLine();
			nameToNum.put(pokemon, i);
			numToName.put(i, pokemon);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String str = br.readLine();

			if (isNumeric(str)) {
				int num = Integer.parseInt(str);
				sb.append(numToName.get(num)).append("\n");
			} else {
				sb.append(nameToNum.get(str)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static boolean isNumeric(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
}
