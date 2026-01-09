import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, D, K, C;
	static int[] belt, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		belt = new int[N];
		count = new int[D + 1];

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int distinct = 0;

		// 초기 윈도우
		for (int i = 0; i < K; i++) {
			int x = belt[i];

			if (count[x] == 0) {
				distinct++;
			}

			count[x]++;
		}

		int max = distinct + (count[C] == 0 ? 1 : 0);

		// 슬라이딩
		for (int i = 1; i < N; i++) {
			// 앞 번호 제거
			int remove = belt[i - 1];
			count[remove]--;

			if (count[remove] == 0) {
				distinct--;
			}

			// 뒷 번호 추가
			int add = belt[(i + K - 1) % N];

			if (count[add] == 0) {
				distinct++;
			}

			count[add]++;

			// 최댓값 갱신
			int curr = distinct + (count[C] == 0 ? 1 : 0);
			max = Math.max(curr, max);
		}

		System.out.println(max);
	}
}