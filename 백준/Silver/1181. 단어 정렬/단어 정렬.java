import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static int n;
	static Set<String> arrSet = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		// 중복 제거를 위한 입력
		for (int i = 0; i < n; i++) {
			arrSet.add(br.readLine());
		}

		List<String> arrList = new ArrayList<>(arrSet);

		arrList.sort((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			}

			return o1.compareTo(o2);
		});

		StringBuilder sb = new StringBuilder();
		for (String s : arrList) {
			sb.append(s + "\n");
		}

		System.out.println(sb.toString());
	}
}
