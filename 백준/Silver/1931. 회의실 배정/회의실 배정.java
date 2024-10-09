import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, endTime, result;
	static int[][] meeting;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		meeting = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meeting, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];    // 종료시간이 같으면 시작시간 기준 오름차순
			}
			return o1[1] - o2[1];        // 종료시간이 빠른 순으로 정렬
		});

		for (int i = 0; i < N; i++) {
			if (endTime <= meeting[i][0]) {
				endTime = meeting[i][1];
				result++;
			}
		}

		System.out.println(result);
	}
}
