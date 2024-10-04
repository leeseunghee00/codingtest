import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static int[][] score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());

			score = new int[N][2];

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				score[j][0] = a;
				score[j][1] = b;
			}

			Arrays.sort(score, (o1, o2) -> o1[0] - o2[0]);

			int result = 1;  // 첫 번째 사람은 무조건 합격
			int minInterviewRank = score[0][1];  // 첫 번째 사람의 면접 순위로 시작

			for (int k = 1; k < N; k++) {
				if (score[k][1] < minInterviewRank) {
					result++;  // 더 높은 순위의 면접을 가진 사람은 합격
					minInterviewRank = score[k][1];  // 최소 면접 순위 갱신
				}
			}

			System.out.println(result);
		}
	}
}
