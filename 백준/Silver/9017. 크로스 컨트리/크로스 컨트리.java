import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());

			// 팀 번호 나열 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] order = new int[n];

			for (int i = 0; i < n; i++) {
				order[i] = Integer.parseInt(st.nextToken());
			}

			// 팀별 완주자 수 카운트
			Map<Integer, Integer> count = new HashMap<>();

			for (int t : order) {
				count.put(t, count.getOrDefault(t, 0) + 1);
			}

			// count < 6 -> 제외
			int score = 1;
			Map<Integer, List<Integer>> scores = new HashMap<>();

			for (int t : order) {
				if (count.get(t) == 6) {
					scores.computeIfAbsent(t, k -> new ArrayList<>()).add(score);
					score++;
				}
			}

			// 우승팀 찾기: 상위 4명 합 최소, 동점이면 5번째(idx 4) 더 빠른 팀
			int winner = 0, bestSum = Integer.MAX_VALUE, bestFifth = Integer.MAX_VALUE;

			for (Map.Entry<Integer, List<Integer>> entry : scores.entrySet()) {
				int team = entry.getKey();
				List<Integer> sc = entry.getValue();

				int sum = sc.get(0) + sc.get(1) + sc.get(2) + sc.get(3);
				int fifth = sc.get(4);

				if (sum < bestSum || (sum == bestSum && fifth < bestFifth)) {
					winner = team;
					bestSum = sum;
					bestFifth = fifth;
				}
			}

			// 출력
			System.out.println(winner);
		}
	}
}
